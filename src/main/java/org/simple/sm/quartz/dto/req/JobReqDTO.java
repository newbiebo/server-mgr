package org.simple.sm.quartz.dto.req;

import lombok.Builder;
import lombok.Data;
import org.simple.sm.common.base.BaseResultDTO;

/**
 *
 */
@Data
public class JobReqDTO {
    private String jobNo;
    private String jobName;
    private String jobGroup;
    private String expression;
    private String status;
}
