package org.simple.sm.quartz.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.simple.sm.backup.service.BackupService;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wangbo
 */
@Slf4j
public class BackupJob implements Job {

    @Resource
    private Scheduler scheduler;
    @Resource
    private BackupService backupService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        try {
            List<JobExecutionContext> currentlyExecutingJobs = scheduler.getCurrentlyExecutingJobs();
            if(!CollectionUtils.isEmpty(currentlyExecutingJobs)){
                for (JobExecutionContext currentlyExecutingJob : currentlyExecutingJobs) {
                    JobKey key = currentlyExecutingJob.getJobDetail().getKey();
                    String substring = key.toString().substring(key.toString().indexOf(".") + 1);
//                    JSONObject jsonObject = GlobalJobCache.allCache.get(substring);

                    log.info("Task execution completed!");
                }
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
