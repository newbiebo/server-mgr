package org.simple.sm.quartz.service;

import org.simple.sm.quartz.dto.req.JobReqDTO;
import org.simple.sm.quartz.dto.res.JobResDTO;

import java.util.List;

public interface JobService {
    /**
     * add job
     * @param jobReqDTO
     */
    JobResDTO addJob(JobReqDTO jobReqDTO);

    /**
     * query jobs
     * @param jobReqDTO
     * @return
     */
    List<JobResDTO>  getJobs(JobReqDTO jobReqDTO);

    /**
     * update job
     * @param jobReqDTO
     */
    void updateJob(JobReqDTO jobReqDTO);

    /**
     * remove job
     * @param jobReqDTO
     */
    void removeJob(JobReqDTO jobReqDTO);
}
