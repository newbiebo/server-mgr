package org.simple.sm.backup.service.impl;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.unit.DataUnit;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lombok.extern.slf4j.Slf4j;
import org.simple.sm.backup.dto.req.BackupManualReqDTO;
import org.simple.sm.backup.dto.req.FilePathReqDTO;
import org.simple.sm.backup.dto.res.BackupManualResDTO;
import org.simple.sm.backup.dto.res.FilePathResDTO;
import org.simple.sm.backup.service.BackupService;
import org.simple.sm.backup.service.FilePathService;
import org.simple.sm.common.constant.ConstantDate;
import org.simple.sm.common.constant.ConstantField;
import org.simple.sm.common.constant.ConstantFile;
import org.simple.sm.common.enumeration.ENUM_BACKUP_TYPE;
import org.simple.sm.common.enumeration.ENUM_BASE_RESULT;
import org.simple.sm.component.snowflake.IdWorker;
import org.simple.sm.db.sqlite.entity.TBackupHistory;
import org.simple.sm.db.sqlite.service.TBackupHistoryService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Slf4j
@Service
public class BackupServiceImpl implements BackupService {

    @Resource
    IdWorker idWorker;
    @Resource
    FilePathService filePathService;
    @Resource
    TBackupHistoryService tBackupHistoryService;

    @Override
    public BackupManualResDTO backupFiles(BackupManualReqDTO backupManualReqDTO) {
        log.info("backupFiles start! parameter：{}", JSONObject.toJSONString(backupManualReqDTO));
        this.checkFilePathExist(backupManualReqDTO.getTargetPath());
        BackupManualResDTO backupManualResDTO = new BackupManualResDTO();
        //nio copy file
        Path destinationFolder = Paths.get(backupManualReqDTO.getTargetPath());
        backupManualReqDTO.getSourceFiles().forEach(m->{
            try {
                Path sourceFile = Paths.get(m);
                Path destinationFile = destinationFolder.resolve(sourceFile.getFileName());
                //copy
                Files.copy(sourceFile, destinationFile, StandardCopyOption.REPLACE_EXISTING);
                //persistent data
                this.insertBackupHistory(backupManualReqDTO);
            } catch (IOException e) {
                e.printStackTrace();
                backupManualResDTO.failure(ENUM_BASE_RESULT.FILE_OPERATE_ERR);
            }
        });
        backupManualResDTO.success(ENUM_BASE_RESULT.SUCCESS);
        log.info("backupFiles end!");
        return backupManualResDTO;
    }

    @Override
    public BackupManualResDTO backupPath(BackupManualReqDTO backupManualReqDTO) {
        log.info("backupPath start! parameter：{}", JSONObject.toJSONString(backupManualReqDTO));
        BackupManualResDTO backupManualResDTO = new BackupManualResDTO();
        this.checkFilePathExist(backupManualReqDTO.getTargetPath());
        try {
            //recursive backup
            this.recursiveBackup(backupManualReqDTO.getSourcePath(), backupManualReqDTO.getTargetPath());
            //persistent data
            this.insertBackupHistory(backupManualReqDTO);
        } catch (IOException e) {
            e.printStackTrace();
            backupManualResDTO.failure(ENUM_BASE_RESULT.FILE_OPERATE_ERR);
        }
        backupManualResDTO.success(ENUM_BASE_RESULT.SUCCESS);
        log.info("backupPath end!");
        return backupManualResDTO;
    }

    @Override
    public BackupManualResDTO backupAfterCompress(BackupManualReqDTO backupManualReqDTO) {
        log.info("backupAfterCompress start! parameter：{}", JSONObject.toJSONString(backupManualReqDTO));
        BackupManualResDTO backupManualResDTO = new BackupManualResDTO();
        try {
            // backup after compress
            this.checkFilePathExist(backupManualReqDTO.getTargetPath());
            if(!StringUtils.isEmpty(backupManualReqDTO.getSourcePath())){
                this.compressFolder(backupManualReqDTO);
            } else if (!CollectionUtils.isEmpty(backupManualReqDTO.getSourceFiles())) {
                this.compressFiles(backupManualReqDTO);
            }
        } catch (IOException e) {
            e.printStackTrace();
            backupManualResDTO.failure(ENUM_BASE_RESULT.FILE_OPERATE_ERR);
        }
        backupManualResDTO.success(ENUM_BASE_RESULT.SUCCESS);
        log.info("backupAfterCompress end");
        return backupManualResDTO;
    }

    /**
     * recursive backup all files in the folder
     * @param sourcePath
     * @param targetPath
     * @throws IOException
     */
    private void recursiveBackup(String sourcePath, String targetPath) throws IOException {
        File sourceDirectory = new File(sourcePath);
        File[] files = sourceDirectory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // Copy files to destination path
                    String destinationFilePath = targetPath + File.separator + file.getName();
                    Files.copy(file.toPath(), new File(destinationFilePath).toPath(), StandardCopyOption.REPLACE_EXISTING);
                } else if (file.isDirectory()) {
                    // Recursive backup of folders
                    String newSourcePath = sourcePath + File.separator + file.getName();
                    String newDestinationPath = targetPath + File.separator + file.getName();
                    //if subdirectory not exist then mkdir
                    File targetFolder = new File(new File(targetPath), file.getName());
                    if (!targetFolder.exists()) {
                        targetFolder.mkdir();
                    }
                    this.recursiveBackup(newSourcePath, newDestinationPath);
                }
            }
        }
    }
    /**
     * compress files and put zip to target path
     * @param backupManualReqDTO
     * @throws IOException
     */
    public void compressFiles(BackupManualReqDTO backupManualReqDTO) throws IOException {
        //default name
        String zipName = backupManualReqDTO.getZipName();
        if(StringUtils.isEmpty(backupManualReqDTO.getZipName())){
            zipName = String.format("%s%s", DateUtil.date(new Date()).toString(ConstantDate.yyyyMMddHHmmssSSS), ConstantFile.ZIP);
        }
        String zipFile = String.format("%s%s",backupManualReqDTO.getTargetPath(),zipName);

        try {
            FileOutputStream fos = new FileOutputStream(zipFile);
            ZipOutputStream zos = new ZipOutputStream(fos);
            for (String sourceFile : backupManualReqDTO.getSourceFiles()) {
                addToZipFile(sourceFile, zos);
            }

            zos.close();
            fos.close();

            log.info("compression completed! ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * compress folder and put zip to target path
     * @param backupManualReqDTO
     * @throws IOException
     */
    private void compressFolder(BackupManualReqDTO backupManualReqDTO) throws IOException {
        //default name
        String zipName = backupManualReqDTO.getZipName();
        if(StringUtils.isEmpty(backupManualReqDTO.getZipName())){
            zipName = String.format("%s%s", DateUtil.date(new Date()).toString(ConstantDate.yyyyMMddHHmmssSSS), ConstantFile.ZIP);
        }
        Path sourcePath = Paths.get(backupManualReqDTO.getSourcePath());
        Path outputPath = Paths.get(backupManualReqDTO.getTargetPath(), zipName);

        try (FileOutputStream fos = new FileOutputStream(outputPath.toFile());
             ZipOutputStream zos = new ZipOutputStream(fos)) {

            Files.walk(sourcePath).filter(path -> !Files.isDirectory(path)).forEach(path -> {
                ZipEntry zipEntry = new ZipEntry(sourcePath.relativize(path).toString());
                try {
                    zos.putNextEntry(zipEntry);
                    Files.copy(path, zos);
                    zos.closeEntry();
                } catch (IOException e) {
                    log.error("Error while adding file to zip: {}", path);
                    e.printStackTrace();
                }
            });
        }
    }
    /**
     * insert data into t_backup_history
     * @param backupManualReqDTO
     */
    private void insertBackupHistory(BackupManualReqDTO backupManualReqDTO){
        BaseMapper<TBackupHistory> baseMapper = tBackupHistoryService.getBaseMapper();
        TBackupHistory tBackupHistory = new TBackupHistory();
        tBackupHistory.setBackupHistoryNo(String.valueOf(idWorker.nextId()));
        tBackupHistory.setType(ENUM_BACKUP_TYPE.MANUAL.getCode());
        tBackupHistory.setJobNo(ConstantField.DEFAULT);
        tBackupHistory.setTargetPath(backupManualReqDTO.getTargetPath());
        tBackupHistory.setResourcePath(backupManualReqDTO.getSourceFiles().toString());
        tBackupHistory.setGmtCreate(new Date());
        tBackupHistory.setGmtModified(new Date());
        baseMapper.insert(tBackupHistory);
    }
    /**
     * check target file path exist,if not create
     * @param filePath  the path to be detected
     */
    private void checkFilePathExist(String filePath){
        FilePathResDTO filePathResDTO = filePathService.filePathSearch(FilePathReqDTO.builder().path(filePath).build());
        if(ENUM_BASE_RESULT.FILE_PATH_ERR.getCode().equals(filePathResDTO.getResultCode())){
            //does not exist,create folder
            File file = new File(filePath);
            file.mkdir();
        }
    }

    private void addToZipFile(String fileName, ZipOutputStream zos) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException("file not exist： " + fileName);
        }

        FileInputStream fis = new FileInputStream(file);
        ZipEntry zipEntry = new ZipEntry(file.getName());
        zos.putNextEntry(zipEntry);

        byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0) {
            zos.write(bytes, 0, length);
        }

        fis.close();
    }
}
