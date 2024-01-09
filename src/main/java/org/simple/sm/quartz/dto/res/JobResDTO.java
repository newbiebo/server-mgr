package org.simple.sm.quartz.dto.res;

import lombok.Builder;
import lombok.Data;
import org.simple.sm.common.base.BaseResultDTO;

@Data
public class JobResDTO extends BaseResultDTO {
    private String jobNo;
    private String jobName;
    private String jobGroup;
    private String expression;
}
