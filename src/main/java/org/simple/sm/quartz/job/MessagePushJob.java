package org.simple.sm.quartz.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.simple.sm.notification.bark.service.BarkService;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * Push title job
 * @author newbiebo
 */
@Slf4j
public class MessagePushJob implements Job {

    @Resource
    private Scheduler scheduler;
    @Resource
    private BarkService barkService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        try {
            List<JobExecutionContext> currentlyExecutingJobs = scheduler.getCurrentlyExecutingJobs();
            if(!CollectionUtils.isEmpty(currentlyExecutingJobs)){
                for (JobExecutionContext currentlyExecutingJob : currentlyExecutingJobs) {
                    JobKey key = currentlyExecutingJob.getJobDetail().getKey();
                    // todo redis
                    barkService.push("","你好");
                    log.info("Task execution completed!");
                }
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
