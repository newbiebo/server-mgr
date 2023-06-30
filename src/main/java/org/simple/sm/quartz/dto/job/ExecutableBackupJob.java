package org.simple.sm.quartz.dto.job;

import lombok.Builder;
import lombok.Data;

@Data
public class ExecutableBackupJob extends ExecutableJob{
    private String resourcePath;
    private String targetPath;
    /**
     * execution task type
     */
    private String type;
}
