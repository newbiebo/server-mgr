package org.simple.sm.common.constant;

public enum ENUM_QUARTZ_BEHAVIOR {

    BACKUP("BACKUP", "备份"),
    BARK("BARK", "消息推送");

    private final String name;
    private final String desc;

    ENUM_QUARTZ_BEHAVIOR(String name, String desc) {
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
