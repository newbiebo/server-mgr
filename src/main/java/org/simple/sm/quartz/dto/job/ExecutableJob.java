package org.simple.sm.quartz.dto.job;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class ExecutableJob {
    private String jobNo;
    private String jobName;
    private String jobGroup;
    private String expression;

}
