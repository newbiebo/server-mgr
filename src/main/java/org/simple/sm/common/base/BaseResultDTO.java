package org.simple.sm.common.base;

import com.alibaba.fastjson2.JSONObject;
import lombok.Data;
import org.simple.sm.common.enumeration.ENUM_BASE_RESULT;

import java.io.Serializable;

/**
 * @author newbiebo
 */
@Data
public class BaseResultDTO<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Interface call successful or failed, 1:success、-1:fail
     */
    private int status;
    /**
     * The specific code for the result
     */
    private String resultCode;
    /**
     * The specific code for the msg
     */
    private String resultMessage;

    private T data;

    public BaseResultDTO() {
    }


    public void failure(ENUM_BASE_RESULT baseResult) {
        this.setStatus(-1);
        this.setResultCode(baseResult.getCode());
        this.setResultMessage(baseResult.getMessage());
    }

    @Override
    public String toString() {
        return "BaseResultDTO{" +
                "resultCode='" + resultCode + '\'' +
                ", resultMessage='" + resultMessage + '\'' +
                '}';
    }
}
