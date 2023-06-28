package org.simple.sm.backup.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lombok.extern.slf4j.Slf4j;
import org.simple.sm.backup.dto.req.BackupManualReqDTO;
import org.simple.sm.backup.service.BackupService;
import org.simple.sm.common.constant.ENUM_BACKUP_TYPE;
import org.simple.sm.db.sqlite.entity.TBackupHistory;
import org.simple.sm.db.sqlite.service.TBackupHistoryService;
import org.simple.sm.utils.SequenceUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
        // todo
    }

    @Override
    public void backupAfterCompress(BackupManualReqDTO backupManualReqDTO) {
        // todo
    }
}
