package org.simple.sm.common.enumeration;

public enum ENUM_BASE_RESULT {

    /**
     * base
     */
    SUCCESS("SUCCESS", "succeed!"),
    FAIL("FAIL", "failed!"),

    /**
     * file
     */
    FILE_PATH_ERR("FILE_PATH_ERR","The specified path does not exist or is not a folder."),
    FILE_OPERATE_ERR("FILE_OPERATE_ERR","An exception occurred while operating the file."),

    /**
     * param
     */
    PARAM_INPUT_ERR("PARAM_INPUT_ERR","The input parameter is incorrect, please check and reinput.");

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
