//package org.simple.sm.notification.email.strategy.impl;
//
//import org.thymeleaf.context.Context;
//import org.simple.sm.notification.email.strategy.MailStrategy;
//import org.simple.sm.notification.email.vo.EmailVO;
//import org.thymeleaf.spring4.SpringTemplateEngine;
//
//
//public class ThymeleafStrategy implements MailStrategy {
//
//    private SpringTemplateEngine springTemplateEngine;
//    private Context context;
//    private String templateName;
//
//    public ThymeleafStrategy setSpringTemplateEngine(SpringTemplateEngine springTemplateEngine) {
//        this.springTemplateEngine = springTemplateEngine;
//        return this;
//    }
//
//    public ThymeleafStrategy(Context context, String templateName) {
//        this.context = context;
//        this.templateName = templateName;
//    }
//
//    public ThymeleafStrategy setContext(Context context) {
//        this.context = context;
//        return this;
//    }
//
//    @Override
//    public String message(EmailVO vo) {
//        String content = this.springTemplateEngine.process(this.templateName, context);
//        return content;
//    }
//}
