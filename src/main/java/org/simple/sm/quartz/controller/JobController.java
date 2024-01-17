package org.simple.sm.quartz.controller;

import org.simple.sm.common.base.BaseResultDTO;
import org.simple.sm.quartz.dto.req.*;
import org.simple.sm.quartz.dto.res.GetJobsResDTO;
import org.simple.sm.quartz.dto.res.JobResDTO;
import org.simple.sm.quartz.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * job controller
 */
@RestController
@RequestMapping("/job")
public class JobController {

    @Resource
    JobService jobService;

    @PostMapping("/save_job")
    public BaseResultDTO<?> addJob(@RequestBody JobReqDTO jobReqDTO) {
        return jobService.addJob(jobReqDTO);
    }
    /**
     * Job query interface
     * @param getJobsReqDTO
     * @return
     */
    @PostMapping("/get_jobs")
    public BaseResultDTO<GetJobsResDTO> getJobs(@RequestBody GetJobsReqDTO getJobsReqDTO) {
        return jobService.getJobs(getJobsReqDTO);
    }
    /**
     * job修改接口
     * @param updateJobReqDTO
     * @return
     * @throws Exception
     */
    @PostMapping("/update_job")
    public BaseResultDTO<?> updateJob(@RequestBody UpdateJobReqDTO updateJobReqDTO) {
        return jobService.updateJob(updateJobReqDTO);
    }
    /**
     * job删除接口
     * @param jobReqDTO
     * @return
     * @throws Exception
     */
    @PostMapping("/remove_job")
    public BaseResultDTO<?> removeJob(@RequestBody JobReqDTO jobReqDTO) {
        return jobService.removeJob(jobReqDTO);
    }

}
