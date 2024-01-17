package org.simple.sm.quartz.dto.res;

import lombok.Data;
import org.simple.sm.db.sqlite.entity.TQuartzInfo;

import java.util.List;

@Data
public class GetJobsResDTO {
    private List<TQuartzInfo>  quartzInfoList;
}
