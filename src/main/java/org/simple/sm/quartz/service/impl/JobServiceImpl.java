package org.simple.sm.quartz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.simple.sm.common.base.BaseResultDTO;
import org.simple.sm.common.constant.ConstantColumn;
import org.simple.sm.common.enumeration.ENUM_BASE_RESULT;
import org.simple.sm.common.enumeration.ENUM_JOB_STATUS;
import org.simple.sm.component.snowflake.IdWorker;
import org.simple.sm.db.sqlite.entity.TQuartzInfo;
import org.simple.sm.db.sqlite.service.TQuartzInfoService;
import org.simple.sm.quartz.dto.req.GetJobsReqDTO;
import org.simple.sm.quartz.dto.req.JobReqDTO;
import org.simple.sm.quartz.dto.req.UpdateJobReqDTO;
import org.simple.sm.quartz.dto.res.GetJobsResDTO;
import org.simple.sm.quartz.service.JobService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Resource
    IdWorker idWorker;
    @Resource
    TQuartzInfoService tQuartzInfoService;

    @Override
    public BaseResultDTO<?> addJob(JobReqDTO jobReqDTO) {
        BaseResultDTO<?> resultDTO = new BaseResultDTO<>();
        jobReqDTO.setJobNo(String.valueOf(idWorker.nextId()));
        if (StringUtils.isEmpty(jobReqDTO.getJobName())
                || StringUtils.isEmpty(jobReqDTO.getJobGroup())
                || StringUtils.isEmpty(jobReqDTO.getExpression())
                || StringUtils.isEmpty(jobReqDTO.getJobType())) {
            resultDTO.failure(ENUM_BASE_RESULT.FAIL);
            return resultDTO;
        }
        //db
        TQuartzInfo tQuartzInfo = new TQuartzInfo();
        tQuartzInfo.setJobNo(String.valueOf(idWorker.nextId()));
        tQuartzInfo.setJobGroup(jobReqDTO.getJobGroup());
        tQuartzInfo.setJobName(jobReqDTO.getJobName());
        tQuartzInfo.setJobType(jobReqDTO.getJobType());
        tQuartzInfo.setExpression(jobReqDTO.getExpression());
        tQuartzInfo.setStatus(ENUM_JOB_STATUS.STOP.getCode());
        tQuartzInfo.setGmtCreate(new Date());
        tQuartzInfo.setGmtModified(new Date());
        tQuartzInfo.setIsDelete(0);
        tQuartzInfoService.getBaseMapper().insert(tQuartzInfo);
        // todo add to local cache
        resultDTO.success();
        return resultDTO;
    }
    @Override
    public BaseResultDTO<GetJobsResDTO> getJobs(GetJobsReqDTO getJobsReqDTO) {
        BaseResultDTO<GetJobsResDTO> resultDTO = new BaseResultDTO<>();
        GetJobsResDTO getJobsResDTO = new GetJobsResDTO();
        QueryWrapper<TQuartzInfo> wrapper = new QueryWrapper<>();
        List<TQuartzInfo> tQuartzInfos = tQuartzInfoService.getBaseMapper().selectList(wrapper);
        getJobsResDTO.setQuartzInfoList(tQuartzInfos);
        resultDTO.success(getJobsResDTO);
        return resultDTO;
    }
    @Override
    public BaseResultDTO<?> updateJob(UpdateJobReqDTO updateJobReqDTO) {
        BaseResultDTO<?> resultDTO = new BaseResultDTO<>();
        if (StringUtils.isEmpty(updateJobReqDTO.getJobNo())) {
            resultDTO.failure(ENUM_BASE_RESULT.PARAM_INPUT_ERR);
            return resultDTO;
        }
        //db
        TQuartzInfo tQuartzInfo = new TQuartzInfo();
        tQuartzInfo.setJobName(updateJobReqDTO.getJobName());
        tQuartzInfo.setJobGroup(updateJobReqDTO.getJobGroup());
        tQuartzInfo.setJobType(updateJobReqDTO.getJobType());
        tQuartzInfo.setStatus(updateJobReqDTO.getStatus());
        tQuartzInfo.setExpression(updateJobReqDTO.getExpression());
        tQuartzInfo.setGmtModified(new Date());
        QueryWrapper<TQuartzInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("job_no",updateJobReqDTO.getJobNo());
        tQuartzInfoService.getBaseMapper().update(tQuartzInfo,wrapper);
        // todo sync local cache
        resultDTO.success();
        return resultDTO;
    }

    @Override
    public  BaseResultDTO<?> removeJob(JobReqDTO jobReqDTO) {
        BaseResultDTO<?> resultDTO = new BaseResultDTO<>();
        if (StringUtils.isEmpty(jobReqDTO.getJobNo())) {
            resultDTO.failure(ENUM_BASE_RESULT.PARAM_INPUT_ERR);
            return resultDTO;
        }
        QueryWrapper<TQuartzInfo> wrapper = new QueryWrapper<>();
        wrapper.eq(ConstantColumn.JOB_NO,jobReqDTO.getJobNo());
        tQuartzInfoService.getBaseMapper().delete(wrapper);
        // todo sync local cache
        resultDTO.success();
        return resultDTO;
    }
}
