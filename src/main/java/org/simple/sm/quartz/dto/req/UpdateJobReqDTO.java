package org.simple.sm.quartz.dto.req;

import lombok.Data;

@Data
public class UpdateJobReqDTO {
    private String jobNo;
    private String jobName;
    private String jobGroup;
    private String jobType;
    private String expression;
    private String status;
}
