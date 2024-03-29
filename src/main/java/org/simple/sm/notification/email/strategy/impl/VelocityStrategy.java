//package org.simple.sm.notification.email.strategy.impl;
//
//import com.google.common.base.Charsets;
//import org.apache.velocity.Template;
//import org.apache.velocity.VelocityContext;
//import org.apache.velocity.app.VelocityEngine;
//import org.simple.sm.notification.email.strategy.MailStrategy;
//import org.simple.sm.notification.email.vo.EmailVO;
//
//import java.io.StringWriter;
//
///**
// * 优化：让使用者更加方便，传入VelocityEngine
// */
//public class VelocityStrategy implements MailStrategy {
//
//    private VelocityEngine velocityEngine;
//    private VelocityContext velocityContext;
//    private String templateName;
//
//    public VelocityStrategy setVelocityEngine(VelocityEngine velocityEngine) {
//        this.velocityEngine = velocityEngine;
//        return this;
//    }
//
//    // 两种注入方式
//    public VelocityStrategy(VelocityContext velocityContext, String templateName) {
//        this.velocityContext = velocityContext;
//        this.templateName = templateName;
//    }
//
//    public VelocityStrategy setVelocityContext(VelocityContext velocityContext) {
//        this.velocityContext = velocityContext;
//        return this;
//    }
//
//    @Override
//    public String message(EmailVO vo) {
//        Template template = this.velocityEngine.getTemplate(this.templateName, Charsets.UTF_8.toString());
//        StringWriter sw = new StringWriter();
//        template.merge(velocityContext, sw);
//        return sw.toString();
//    }
//}
