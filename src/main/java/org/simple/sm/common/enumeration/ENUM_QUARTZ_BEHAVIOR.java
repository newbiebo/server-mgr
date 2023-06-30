package org.simple.sm.common.enumeration;

public enum ENUM_QUARTZ_BEHAVIOR {

    BACKUP("BACKUP", "备份"),
    BARK("BARK", "消息推送");

    private final String code;
    private final String desc;

    ENUM_QUARTZ_BEHAVIOR(String code, String desc) {
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
