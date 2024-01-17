package org.simple.sm.quartz.service.impl;

import org.quartz.*;
import org.simple.sm.quartz.service.QuartzService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class QuartzServiceImpl implements QuartzService {

    public static String SCHEDULER_OPR_START = "start";
    public static String SCHEDULER_OPR_PAUSE = "pause";
    public static String SCHEDULER_OPR_RESUME = "resume";
    public static String SCHEDULER_OPR_REMOVE = "remove";
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private Scheduler scheduler;

    @Override
    public void addJob() {
    }

    @Override
    public void startJob(String taskCode, String taskAnme, String cron, String jobGroup,
                         String className) throws Exception {
        Class<Job> jobClass = null;
        try {
            jobClass = (Class<Job>) Class.forName(className);
            // Get the task execution class
        } catch (ClassNotFoundException e) {
            throw new Exception("Task class does not exist!");
        }
        // Create a job and specify the job name and grouping
        JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(taskCode, jobGroup).build();
        // Create Expression Work Plan
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
        // Create cronTrigger
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(taskCode, jobGroup)
                .withSchedule(cronScheduleBuilder).build();
        scheduler.scheduleJob(jobDetail, cronTrigger);
        scheduler.start();
        logger.info("--------" + taskAnme + " scheduler start ! JobNo: " + taskCode + "------------");
    }

    @Override
    public void modifyJob(String taskCode, String jobGroup, String cron) throws Exception {
        TriggerKey triggerKey = new TriggerKey(taskCode, jobGroup);
        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        String oldCron = trigger.getCronExpression();
        if (!oldCron.equals(cron)) {
            CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(taskCode, jobGroup)
                    .withSchedule(CronScheduleBuilder.cronSchedule(cron)).build();
            Date date = scheduler.rescheduleJob(triggerKey, cronTrigger);
            if (date == null) {
                throw new Exception("Error in modifying the execution time of a scheduled task!");
            }
        }
    }

    @Override
    public void pauseJob(String taskCode, String jobGroup) throws Exception {
        JobKey jobKey = new JobKey(taskCode, jobGroup);
        JobDetail jobDetail = scheduler.getJobDetail(jobKey);
        if (jobDetail == null) {
            return;
        }
        scheduler.pauseJob(jobKey);
    }

    @Override
    public void resumeJob(String taskCode, String jobGroup) throws Exception {
        JobKey jobKey = new JobKey(taskCode, jobGroup);
        JobDetail jobDetail = scheduler.getJobDetail(jobKey);
        if (jobDetail == null) {
            return;
        }
        scheduler.resumeJob(jobKey);
    }

    @Override
    public void deleteJob(String taskCode, String jobGroup) throws Exception {
        JobKey jobKey = new JobKey(taskCode, jobGroup);
        JobDetail jobDetail = scheduler.getJobDetail(jobKey);
        if (jobDetail == null) {
            return;
        }
        scheduler.deleteJob(jobKey);
    }
}
