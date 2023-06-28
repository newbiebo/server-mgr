package org.simple.sm.common.constant;


public enum ENUM_BACKUP_TYPE {
    MANUAL("MANUAL", "手动执行"),
    TASK("TASK", "任务执行");

    private final String name;
    private final String desc;

    ENUM_BACKUP_TYPE(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}
