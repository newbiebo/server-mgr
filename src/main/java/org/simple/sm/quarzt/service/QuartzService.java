package org.simple.sm.quarzt.service;

/**
 * @author newbiebo
 * Execute scheduled tasks
 */
public interface QuartzService {
    /**
     * Launch Task
     *
     * @param taskCode
     * @param taskAnme
     * @param cron
     * @param jobGroup
     * @param className
     * @throws Exception
     */
    void startJob(String taskCode, String taskAnme, String cron, String jobGroup,String className) throws Exception;

    /**
     * Modify scheduled task execution time
     *
     * @param taskCode
     * @param jobGroup
     * @param cron new scheduled time
     * @throws Exception
     */
    void modifyJob(String taskCode, String jobGroup, String cron) throws Exception;
    /**
     * Pause a scheduled task (after the task resumes,
     * tasks that were not executed during the pause period will continue to be executed.
     * If there are 2 times during the pause period, they will be executed 2 times)
     *
     * @param taskCode
     * @param jobGroup
     * @throws Exception
     */
    void pauseJob(String taskCode, String jobGroup) throws Exception;
    /**
     * Restore a scheduled task
     *
     * @param taskCode
     * @param jobGroup
     * @throws Exception
     */
    void resumeJob(String taskCode, String jobGroup) throws Exception;
    /**
     * Delete a scheduled task
     *
     * @param taskCode
     * @param jobGroup
     * @throws Exception
     */
    void deleteJob(String taskCode, String jobGroup) throws Exception;
}
