package org.simple.sm.quartz.service;

import org.simple.sm.external.bark.dto.PushReq;

/**
 * @author newbiebo
 */
public interface MessagePushService {

    /**推送所有类型的消息*/
    void push(PushReq pushReq);

}
