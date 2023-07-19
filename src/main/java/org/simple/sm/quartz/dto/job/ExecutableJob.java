package org.simple.sm.quartz.dto.job;

import lombok.Data;

@Data
public class ExecutableJob {

    private String jobNo;
    private String jobName;
    private String jobGroup;
    private String expression;
    /**
     * execution task type
     */
    private String type;

}
