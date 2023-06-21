package org.simple.sm.quartz.service.impl;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.simple.sm.config.Properties;
import org.simple.sm.external.bark.dto.PushReq;
import org.simple.sm.quartz.service.MessagePushService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author newbiebo
 */
@Slf4j
@Service
public class MessagePushServiceImpl implements MessagePushService {

    @Resource
    Properties properties;

    @Override
    public void push(PushReq pushReq) {
//        log.info("PushService.push(),入参为:{}", JSONObject.toJSONString(pushReq));
//        StringBuilder append = new StringBuilder("http://").append(properties.getBarkServerUrl()).append("/").append(pushReq.getKey()).append(pushReq.getUrl());
//        log.info("请求连接为:{}", append);
//        String resStr = HttpUtil.get(append.toString());
//        if (null != resStr && !"".equals(resStr)) {
//            // todo
//            JSONObject jsonObject = JSON.parseObject(resStr);
//        }
    }
}
