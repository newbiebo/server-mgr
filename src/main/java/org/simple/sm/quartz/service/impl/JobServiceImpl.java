package org.simple.sm.quartz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.simple.sm.common.enumeration.ENUM_JOB_STATUS;
import org.simple.sm.db.sqlite.entity.TQuartzInfo;
import org.simple.sm.db.sqlite.service.TQuartzInfoService;
import org.simple.sm.quartz.dto.req.JobReqDTO;
import org.simple.sm.quartz.dto.res.JobResDTO;
import org.simple.sm.quartz.service.JobService;
import org.simple.sm.common.utils.SequenceUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Resource
    TQuartzInfoService tQuartzInfoService;

    @Override
    public void addJob(JobReqDTO jobReqDTO) {
        //db
        TQuartzInfo tQuartzInfo = new TQuartzInfo();
        tQuartzInfo.setJobNo(SequenceUtil.generateId());
        tQuartzInfo.setJobGroup(jobReqDTO.getJobGroup());
        tQuartzInfo.setJobName(jobReqDTO.getJobName());
        tQuartzInfo.setExpression(jobReqDTO.getExpression());
        tQuartzInfo.setStatus(ENUM_JOB_STATUS.STOP.getCode());
        tQuartzInfo.setGmtCreate(new Date());
        tQuartzInfo.setGmtModified(new Date());
        tQuartzInfo.setIsDelete(0);
        tQuartzInfoService.getBaseMapper().insert(tQuartzInfo);
        // todo add to local cache
    }
    @Override
    public List<JobResDTO> getJobs(JobReqDTO jobReqDTO) {
        List<JobResDTO> jobResDTOs = new ArrayList<>();
        QueryWrapper<TQuartzInfo> wrapper = new QueryWrapper<>();
        List<TQuartzInfo> tQuartzInfos = tQuartzInfoService.getBaseMapper().selectList(wrapper);
        tQuartzInfos.forEach(e->
            jobResDTOs.add(JobResDTO.builder()
                    .jobNo(e.getJobNo())
                    .jobName(e.getJobName())
                    .jobGroup(e.getJobGroup())
                    .expression(e.getExpression())
                    .build())
        );
        return jobResDTOs;
    }
    @Override
    public void updateJob(JobReqDTO jobReqDTO) {
        //db
        TQuartzInfo tQuartzInfo = new TQuartzInfo();
        tQuartzInfo.setJobName(jobReqDTO.getJobName());
        tQuartzInfo.setJobGroup(jobReqDTO.getJobGroup());
        tQuartzInfo.setStatus(jobReqDTO.getStatus());
        tQuartzInfo.setExpression(jobReqDTO.getExpression());
        tQuartzInfo.setGmtModified(new Date());
        QueryWrapper<TQuartzInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("job_no",jobReqDTO.getJobNo());
        tQuartzInfoService.getBaseMapper().update(tQuartzInfo,wrapper);
        // todo sync local cache
    }

    @Override
    public void removeJob(JobReqDTO jobReqDTO) {
        QueryWrapper<TQuartzInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("job_no",jobReqDTO.getJobNo());
        tQuartzInfoService.getBaseMapper().delete(wrapper);
        // todo sync local cache
    }
}
