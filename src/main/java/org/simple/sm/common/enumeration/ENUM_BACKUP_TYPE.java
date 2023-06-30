package org.simple.sm.common.enumeration;


public enum ENUM_BACKUP_TYPE {
    MANUAL("MANUAL", "手动执行"),
    TASK("TASK", "任务执行");

    private final String code;
    private final String desc;

    ENUM_BACKUP_TYPE(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
