package org.simple.sm.quartz.run;

import lombok.extern.slf4j.Slf4j;
import org.simple.sm.db.sqlite.service.ZJobService;
import org.simple.sm.quartz.dto.job.ExecutableBackupJob;
import org.simple.sm.quartz.dto.job.ExecutableJob;
import org.simple.sm.quartz.service.QuartzService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author newbiebo
 */
@Slf4j
@Component
@Order(value = 2)
public class InitJobApplicationRunner implements ApplicationRunner {

    @Resource
    QuartzService quartzService;
    @Resource
    ZJobService zJobService;

    @Override
    public void run(ApplicationArguments args) {
        //traverse each job and execute
        this.getJobList().forEach(e->{
            try{
                String className = e.getType();
                quartzService.startJob(
                        e.getJobNo(),
                        e.getJobName(),
                        e.getExpression()
                        ,e.getJobGroup(),
                        className
                );
            }catch (Exception ex){
                log.error("Initialize jobs exception,as:{}",ex.getMessage());
            }

        });
    }
    //obtain all executable jobs
    private List<ExecutableBackupJob> getJobList() {
        List<ExecutableBackupJob> executableJobs = new ArrayList<>();
        zJobService.getBuckupJobList().forEach(e->
        {
            ExecutableBackupJob executableBackupJob = new ExecutableBackupJob();
            executableBackupJob.setJobNo(e.getJobNo());
            executableBackupJob.setJobName(e.getJobNo());
            executableBackupJob.setJobGroup(e.getJobGroup());
            executableBackupJob.setExpression(e.getExpression());
            executableBackupJob.setType(e.get)
                    .jobName(e.getJobName())
                    .jobGroup(e.getJobGroup())
                    .expression(e.getExpression())
                    .resourcePath(e.getResourcePath())
                    .targetPath(e.getTargetPath())
                    .type(e.getType())
                    .build();
            executableJobs.add(

        })
        );
        return executableJobs;
    }
}
