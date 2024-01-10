package org.simple.sm.backup.service;

import org.simple.sm.backup.dto.req.BackupManualReqDTO;
import org.simple.sm.backup.dto.res.BackupManualResDTO;

/**
 * backupService
 */
public interface BackupService {
    /**
     * Backup specified files
     * @param backupManualReqDTO
     * @return
     */
    BackupManualResDTO backupFiles(BackupManualReqDTO backupManualReqDTO);

    /**
     * Backup all files in the path
     * @param backupManualReqDTO
     * @return
     */
    BackupManualResDTO backupPath(BackupManualReqDTO backupManualReqDTO);

    /**
     *  Compress before backup
     * @param backupManualReqDTO
     * @return
     */
    BackupManualResDTO backupAfterCompress(BackupManualReqDTO backupManualReqDTO);

}
