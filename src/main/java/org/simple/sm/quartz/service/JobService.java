package org.simple.sm.quartz.service;

import org.simple.sm.quartz.dto.req.JobReqDTO;
import org.simple.sm.quartz.dto.res.JobResDTO;

import java.util.List;

public interface JobService {
    /**
     * 添加任务
     * @param jobReqDTO
     */
    JobResDTO addJob(JobReqDTO jobReqDTO);
    List<JobResDTO>  getJobs(JobReqDTO jobReqDTO);
    void updateJob(JobReqDTO jobReqDTO);
    void removeJob(JobReqDTO jobReqDTO);
}
