package org.simple.sm.common.base;

import lombok.Data;

import java.io.Serializable;

/**
 * @author newbiebo
 */
@Data
public class BaseResultDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String resultCode = "1";
    private String resultMessage;

    public BaseResultDTO() {
    }


    public void failure(String resultMessage) {
        this.setResultCode("0");
        this.setResultMessage(resultMessage);
    }

    @Override
    public String toString() {
        return "BaseResultDTO{" +
                "resultCode='" + resultCode + '\'' +
                ", resultMessage='" + resultMessage + '\'' +
                '}';
    }
}
