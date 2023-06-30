package org.simple.sm.common.enumeration;

public enum ENUM_USER_CLIENT {

    IPHONE("IPHONE", "手机"),
    IPAD("IPAD", "平板"),
    IMAC("IMAC", "笔记本");

    private final String name;
    private final String desc;

    ENUM_USER_CLIENT(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
}
