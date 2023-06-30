package org.simple.sm.common.enumeration;

public enum ENUM_JOB_STATUS {
    STOP("STOP", "停止"),
    START("START", "开始");

    private final String code;
    private final String desc;

    ENUM_JOB_STATUS(String code, String desc) {
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
