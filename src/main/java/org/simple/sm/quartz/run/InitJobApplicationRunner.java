package org.simple.sm.quartz.run;

import lombok.extern.slf4j.Slf4j;
import org.simple.sm.db.sqlite.service.ZJobService;
import org.simple.sm.quartz.dto.job.ExecutableBackupJob;
import org.simple.sm.quartz.dto.job.ExecutableBarkJob;
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
        List<ExecutableJob> jobList = this.getJobList();
        jobList.forEach(e->{
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
            log.info("Initialize jobs successful! current jobs include:{}",jobList);
        });
    }
    //obtain all executable jobs
    private List<ExecutableJob> getJobList() {

//        List<ExecutableBackupJob> executableBackupJobs = zJobService.getBuckupJobList();
        List<ExecutableBarkJob> executableBarkJobs = zJobService.getBarkJobList();
        List<ExecutableJob> newExecutableJobs = new ArrayList<>();
        executableBarkJobs.forEach(e->
        {
            ExecutableJob  executableJob = new ExecutableJob();
            executableJob.setJobNo(e.getJobNo());
            executableJob.setJobName(e.getJobNo());
            executableJob.setJobGroup(e.getJobGroup());
            executableJob.setExpression(e.getExpression());
            executableJob.setType(e.getType());
            newExecutableJobs.add(executableJob);
        });
//        executableBackupJobs.forEach(e->
//        {
//            ExecutableJob  executableJob = new ExecutableJob();
//            executableJob.setJobNo(e.getJobNo());
//            executableJob.setJobName(e.getJobNo());
//            executableJob.setJobGroup(e.getJobGroup());
//            executableJob.setExpression(e.getExpression());
//            executableJob.setType(e.getType());
//            newExecutableJobs.add(executableJob);
//
//        });
        return newExecutableJobs;
    }
}
