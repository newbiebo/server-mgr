package org.simple.sm.common.enumeration;

/**
 * enumeration of job names for specific execution tasks
 */
public enum ENUM_JOB_NAME {
    /**
     * backup task job
     */
    BACKUP_JOB("org.simple.sm.quartz.job.BackupJob"),
    /**
     * bark msg req job
     */
    BARK_MSG_JOB("org.simple.sm.quartz.job.BarkMsgJob"),
    ;
    private final String value;

    ENUM_JOB_NAME(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
