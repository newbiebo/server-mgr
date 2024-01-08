//package org.simple.sm.notification.email.config;
//
//import lombok.Data;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
///**
// * 邮件配置类
// */
//@Data
//@Component
//public class MailConfig {
//
//        /**
//     * 邮件接收人
//     */
//    @Value("#{'${mail.receivers}'.split(',')}")
//    private List<String> mailReceivers;
//
//    /**
//     * 邮件抄送
//     */
//    @Value("#{'${mail.cc}'.split(',')}")
//    private List<String> mailCc;
//
//    /**
//     *  邮件密送
//     */
//    @Value("#{'${mail.bcc}'.split(',')}")
//    private List<String> mailBcc;
//
//    /**
//     * 邮件发送者
//     */
//    @Value("${mail.sender}")
//    private String mailSender;
//
//    /**
//     * 邮件服务器
//     */
//    @Value("${mail.host}")
//    private String mailHost;
//
//    /**
//     *  邮箱用户名
//     */
//    @Value("${mail.username}")
//    private String mailUserName;
//
//    /**
//     * 邮箱密码
//     */
//    @Value("${mail.password}")
//    private String mailPassWd;
//
//    /**
//     *  端口号
//     */
//    @Value("${mail.port}")
//    private int mailPort;
//
//
//}
