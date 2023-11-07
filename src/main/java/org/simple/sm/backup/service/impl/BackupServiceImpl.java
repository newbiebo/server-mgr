package org.simple.sm.backup.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lombok.extern.slf4j.Slf4j;
import org.simple.sm.backup.dto.req.BackupManualReqDTO;
import org.simple.sm.backup.service.BackupService;
import org.simple.sm.common.enumeration.ENUM_BACKUP_TYPE;
import org.simple.sm.db.sqlite.entity.TBackupHistory;
import org.simple.sm.db.sqlite.service.TBackupHistoryService;
import org.simple.sm.common.utils.SequenceUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;

@Slf4j
@Service
public class BackupServiceImpl implements BackupService {

    @Resource
    TBackupHistoryService tBackupHistoryService;

    @Override
    public void backupFiles(BackupManualReqDTO backupManualReqDTO) {
        BaseMapper<TBackupHistory> baseMapper = tBackupHistoryService.getBaseMapper();
        //nio copy file
        Path destinationFolder = Paths.get(backupManualReqDTO.getTargetPath());
        backupManualReqDTO.getSourceFiles().forEach(e->{
            Path sourceFile = Paths.get(e);
            Path destinationFile = destinationFolder.resolve(sourceFile.getFileName());
            try {
                //copy
                Files.copy(sourceFile, destinationFile, StandardCopyOption.REPLACE_EXISTING);
                //persistent data
                TBackupHistory tBackupHistory = new TBackupHistory();
                tBackupHistory.setBackupHistoryNo(SequenceUtil.generateId());
                tBackupHistory.setType(ENUM_BACKUP_TYPE.MANUAL.getCode());
                tBackupHistory.setJobNo("default");
                tBackupHistory.setTargetPath(backupManualReqDTO.getTargetPath());
                tBackupHistory.setResourcePath(backupManualReqDTO.getSourceFiles().toString());
                tBackupHistory.setGmtCreate(new Date());
                tBackupHistory.setGmtModified(new Date());
                baseMapper.insert(tBackupHistory);
            } catch (IOException ex) {
                log.error("An exception occurred while copying the file! as {}",ex.getMessage());
            }
        });
    }

    @Override
    public void backupPath(BackupManualReqDTO backupManualReqDTO) {
        try {
            //Recursive backup
            recursiveBackup(backupManualReqDTO.getSourcePath(), backupManualReqDTO.getTargetPath());
            log.info("Backup completed!");
        } catch (IOException e) {
            log.error("Backup failed! as:{}", e.getMessage());
        }
    }

    @Override
    public void backupAfterCompress(BackupManualReqDTO backupManualReqDTO) {
        // todo backup After Compress
    }

    private static void recursiveBackup(String sourcePath, String targetPath) throws IOException {
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
                    recursiveBackup(newSourcePath, newDestinationPath);
                }
            }
        }
    }
}
