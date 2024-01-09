package org.simple.sm.common.enumeration;

public enum ENUM_BASE_RESULT {

    SUCCESS("0", "successful!"),
    FILED("-1", "filed!");

    private final String code;
    private final String message;

    ENUM_BASE_RESULT(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
