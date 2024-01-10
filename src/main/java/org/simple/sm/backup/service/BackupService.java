package org.simple.sm.backup.service;

import org.simple.sm.backup.dto.req.BackupManualReqDTO;
import org.simple.sm.backup.dto.res.BackupManualResDTO;

public interface BackupService {
    //Backup specified files
    BackupManualResDTO backupFiles(BackupManualReqDTO backupManualReqDTO);
    //Backup all files in the path
    BackupManualResDTO backupPath(BackupManualReqDTO backupManualReqDTO);
    //Compress before backup
    BackupManualResDTO backupAfterCompress(BackupManualReqDTO backupManualReqDTO);

}
