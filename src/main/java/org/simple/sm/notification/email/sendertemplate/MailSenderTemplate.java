//package org.simple.sm.notification.email.sendertemplate;
//
//import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
//import org.simple.sm.notification.email.sendertemplate.impl.MailSenderTemplateImpl;
//import org.simple.sm.notification.email.strategy.MailStrategy;
//import org.simple.sm.notification.email.vo.EmailVO;
//
//public interface MailSenderTemplate {
//
//    /**
//     * 发送邮件
//     *
//     * @param vo
//     */
//    void sendMail(EmailVO vo) throws MessagingException, javax.mail.MessagingException;
//
//    /**
//     * 异步发送邮件
//     *
//     * @param vo
//     * @throws MessagingException
//     */
//    void sendMailSync(EmailVO vo) throws MessagingException;
//
//    /**
//     * 设置邮件发送策略
//     *
//     * @param strategy
//     * @return
//     */
//    MailSenderTemplateImpl setStrategy(MailStrategy strategy);
//}
