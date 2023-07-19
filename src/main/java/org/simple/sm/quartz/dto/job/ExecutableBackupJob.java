package org.simple.sm.quartz.dto.job;

import lombok.Data;

@Data
public class ExecutableBackupJob extends ExecutableJob{

    private String resourcePath;
    private String targetPath;

}
