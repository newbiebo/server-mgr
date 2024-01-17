package org.simple.sm.quartz.service;

import org.simple.sm.common.base.BaseResultDTO;
import org.simple.sm.quartz.dto.req.GetJobsReqDTO;
import org.simple.sm.quartz.dto.req.JobReqDTO;
import org.simple.sm.quartz.dto.req.UpdateJobReqDTO;
import org.simple.sm.quartz.dto.res.GetJobsResDTO;
import org.simple.sm.quartz.dto.res.JobResDTO;

import java.util.List;

public interface JobService {
    /**
     * add job
     * @param jobReqDTO
     */
    BaseResultDTO<?> addJob(JobReqDTO jobReqDTO);

    /**
     * query job list
     * @param getJobsReqDTO
     * @return
     */
    BaseResultDTO<GetJobsResDTO>  getJobs(GetJobsReqDTO getJobsReqDTO);

    /**
     * update job
     * @param updateJobReqDTO
     */
    BaseResultDTO<?> updateJob(UpdateJobReqDTO updateJobReqDTO);

    /**
     * remove job
     * @param jobReqDTO
     */
    BaseResultDTO<?> removeJob(JobReqDTO jobReqDTO);
}
