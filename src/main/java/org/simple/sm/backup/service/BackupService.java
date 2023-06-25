package org.simple.sm.backup.service;

import org.simple.sm.backup.dto.req.BackupManualReqDTO;

public interface BackupService {
    //Backup specified files
    void backupFiles(BackupManualReqDTO backupManualReqDTO);
    //Backup all files in the path
    void backupPath(BackupManualReqDTO backupManualReqDTO);
    //Compress and backup
    void backupAfterCompress(BackupManualReqDTO backupManualReqDTO);

}
