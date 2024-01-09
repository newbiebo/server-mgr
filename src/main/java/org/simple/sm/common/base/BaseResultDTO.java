package org.simple.sm.common.base;

import lombok.Data;
import org.simple.sm.common.enumeration.ENUM_BASE_RESULT;

import java.io.Serializable;

/**
 * @author newbiebo
 */
@Data
public class BaseResultDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private String resultCode;
    private String resultMessage;

    public BaseResultDTO() {
    }


    public void failure(ENUM_BASE_RESULT baseResult) {
        this.setResultCode(baseResult.getCode());
        this.setResultMessage(baseResult.getMessage());
    }

    public void success(ENUM_BASE_RESULT baseResult) {
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
