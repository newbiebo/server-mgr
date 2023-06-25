package org.simple.sm.backup.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.simple.sm.backup.dto.req.BackupManualReqDTO;
import org.simple.sm.backup.service.BackupService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Slf4j
@Service
public class BackupServiceImpl implements BackupService {

    @Override
    public void backupFiles(BackupManualReqDTO backupManualReqDTO) {
        //nio copy file
        Path destinationFolder = Paths.get(backupManualReqDTO.getTargetPath());
        backupManualReqDTO.getSourceFiles().forEach(e->{
            Path sourceFile = Paths.get(e);
            Path destinationFile = destinationFolder.resolve(sourceFile.getFileName());
            try {
                Files.copy(sourceFile, destinationFile, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException ex) {
                log.error("file copy filed! as {}",ex.getMessage());
            }
        });
        //history to db todo
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
