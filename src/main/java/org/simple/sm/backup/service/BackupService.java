package org.simple.sm.backup.service;

import org.simple.sm.backup.dto.req.BackupManualReqDTO;
import org.simple.sm.common.base.BaseResultDTO;

/**
 * backupService
 */
public interface BackupService {

    /**
     * Backup specified files
     * @param backupManualReqDTO
     * @return
     */
    BaseResultDTO<?> backupFiles(BackupManualReqDTO backupManualReqDTO);

    /**
     * Backup all files in the path
     * @param backupManualReqDTO
     * @return
     */
    BaseResultDTO<?> backupPath(BackupManualReqDTO backupManualReqDTO);

    /**
     *  Compress before backup
     * @param backupManualReqDTO
     * @return
     */
    BaseResultDTO<?> backupAfterCompress(BackupManualReqDTO backupManualReqDTO);

}
