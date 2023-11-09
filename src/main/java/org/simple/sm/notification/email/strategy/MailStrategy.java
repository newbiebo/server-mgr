package org.simple.sm.notification.email.strategy;

import org.simple.sm.notification.email.vo.EmailVO;

public interface MailStrategy {

    String message(EmailVO vo);
}
