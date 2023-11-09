package org.simple.sm.notification.email.strategy.impl;


import org.simple.sm.notification.email.strategy.MailStrategy;
import org.simple.sm.notification.email.vo.EmailVO;
import org.springframework.stereotype.Component;


@Component
public class TextStrategy implements MailStrategy {

    @Override
    public String message(EmailVO vo) {
        return vo.getEmailContent();
    }
}
