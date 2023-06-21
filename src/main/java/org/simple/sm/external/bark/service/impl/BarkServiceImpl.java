package org.simple.sm.external.bark.service.impl;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.simple.sm.config.Properties;
import org.simple.sm.external.bark.dto.PushReq;
import org.simple.sm.external.bark.service.BarkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class BarkServiceImpl implements BarkService {

    @Resource
    Properties properties;

    @Override
    public void push(PushReq pushReq) {
//        log.info("PushService.push(),Enter as:{}", JSONObject.toJSONString(pushReq));
//        StringBuilder append = new StringBuilder("http://")
//                .append(properties.getBarkServerUrl())
//                .append("/")
//                .append(pushReq.getKey())
//                .append(pushReq.getUrl());
//        log.info("Request connection as:{}", append);
//        String resStr = HttpUtil.get(append.toString());
//        if (null != resStr && !"".equals(resStr)) {
//            JSONObject jsonObject = JSON.parseObject(resStr);
//            // todo
////            String code = jsonObject.getString(ENUM_RES_FIELD.CODE.getKey());
//        }
    }
}
