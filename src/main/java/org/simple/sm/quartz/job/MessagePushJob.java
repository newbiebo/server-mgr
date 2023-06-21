package org.simple.sm.quartz.job;

import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.simple.sm.external.bark.dto.PushReq;
import org.simple.sm.quartz.cache.GlobalJobCache;
import org.simple.sm.quartz.service.MessagePushService;
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
    private MessagePushService messagePushService;
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
