package org.simple.sm.backup.dto.req;

import lombok.Data;

import java.util.List;

@Data
public class BackupManualReqDTO {

    /**
     * Path of the files to be backed up
     */
    private List<String> sourceFiles;
    /**
     * Path of the folder to be backed up
     */
    private String sourcePath;
    /**
     * Backup destination path
     */
    private String targetPath;
    /**
     * compressed zip name
     */
    private String zipName;

}
