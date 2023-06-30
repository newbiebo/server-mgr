package org.simple.sm.quartz.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;

import javax.annotation.Resource;

/**
 * Push title job
 * @author newbiebo
 */
@Slf4j
public class MessagePushJob implements Job {

//    @Resource
//    private MessagePushService messagePushService;
    @Resource
    private Scheduler scheduler;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
//        try {
//            List<JobExecutionContext> currentlyExecutingJobs = scheduler.getCurrentlyExecutingJobs();
//            if(!CollectionUtils.isEmpty(currentlyExecutingJobs)){
//                for (JobExecutionContext currentlyExecutingJob : currentlyExecutingJobs) {
//                    JobKey key = currentlyExecutingJob.getJobDetail().getKey();
//                    String substring = key.toString().substring(key.toString().indexOf(".") + 1);
//                    JSONObject jsonObject = GlobalJobCache.allCache.get(substring);
//                    PushReq pushReq = new PushReq();
//                    pushReq.setUrl(jsonObject.getString("url"));
//                    pushReq.setKey(jsonObject.getString("key"));
//                    pushReq.setClient(jsonObject.getString("client"));
//                    messagePushService.push(pushReq);
//                    log.info("Task execution completed!");
//                }
//            }
//        } catch (SchedulerException e) {
//            e.printStackTrace();
//        }
    }
}
