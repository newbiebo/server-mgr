package org.simple.sm.backup.service;

import java.util.List;

public interface BackupService {
    //Backup specified files
    void backupFiles(List<String> sourceFiles, String targetPath);
    //Backup all files in the path
    void backupPath(String sourcePath,String targetPath);
    //Compress and backup
    void backupAfterCompress(List<String> sourceFiles,String targetPath);

}
