package org.simple.sm.quartz.controller;

import org.simple.sm.common.base.BaseResultDTO;
import org.simple.sm.quartz.dto.req.JobReqDTO;
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
    public ResponseEntity<JobResDTO> addJob(@RequestBody JobReqDTO jobReqDTO) {
        JobResDTO jobResDTO = jobService.addJob(jobReqDTO);
        return new ResponseEntity<>(jobResDTO, HttpStatus.OK);
    }
    /**
     * Job query interface
     * @param jobReqDTO
     * @return
     */
    @PostMapping("/get_jobs")
    public ResponseEntity<List<JobResDTO>> getJobs(@RequestBody JobReqDTO jobReqDTO) {
        return new ResponseEntity<>(jobService.getJobs(jobReqDTO), HttpStatus.OK);
    }
    /**
     * job修改接口
     * @param jobReqDTO
     * @return
     * @throws Exception
     */
    @PostMapping("/update_job")
    public ResponseEntity<BaseResultDTO> updateJob(@RequestBody JobReqDTO jobReqDTO) {
        BaseResultDTO baseResultDTO = new BaseResultDTO();
        if (StringUtils.isEmpty(jobReqDTO.getJobNo())) {
            baseResultDTO.setResultCode("0");
            baseResultDTO.setResultMessage(" No item to modify specified!");
            return new ResponseEntity<>(baseResultDTO, HttpStatus.OK);
        } else if (StringUtils.isEmpty(jobReqDTO.getJobName())
                && StringUtils.isEmpty(jobReqDTO.getExpression())
                && StringUtils.isEmpty(jobReqDTO.getJobGroup())) {
            baseResultDTO.setResultCode("0");
            baseResultDTO.setResultMessage(" The current content has not been modified!");
            return new ResponseEntity<>(baseResultDTO, HttpStatus.OK);
        }
        jobService.updateJob(jobReqDTO);
        return new ResponseEntity<>(baseResultDTO, HttpStatus.OK);
    }
    /**
     * job删除接口
     * @param jobReqDTO
     * @return
     * @throws Exception
     */
    @PostMapping("/remove_job")
    public ResponseEntity<BaseResultDTO> removeJob(@RequestBody JobReqDTO jobReqDTO) {
        BaseResultDTO baseResultDTO = new BaseResultDTO();
        if (StringUtils.isEmpty(jobReqDTO.getJobNo())) {
            baseResultDTO.setResultCode("0");
            baseResultDTO.setResultMessage(" The input parameter is incorrect, please check and input! ");
            return new ResponseEntity<>(baseResultDTO, HttpStatus.OK);
        }
        jobService.removeJob(jobReqDTO);
        return new ResponseEntity<>(baseResultDTO, HttpStatus.OK);
    }

}
