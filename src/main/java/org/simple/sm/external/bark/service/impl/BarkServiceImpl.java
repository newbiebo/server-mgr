package org.simple.sm.external.bark.service.impl;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.simple.sm.external.bark.service.BarkService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class BarkServiceImpl implements BarkService {

    @Value("${env.bark.server.url}")
    private String barkServerUrl;
    @Value("${env.bark.server.keys}")
    private String keys;

    @Override
    public void push(String group, String msg) {
        this.doPush(group,msg);
    }

    @Override
    public void push(String group, String title, String msg) {

    }

    @Override
    public void push(String group, String title, String msg, String url) {

    }
}
