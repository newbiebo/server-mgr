package org.simple.sm.external.bark.service.impl;

import cn.hutool.http.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.simple.sm.external.bark.service.BarkService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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

    private void doPush(String group, String title, String msg, String url){
        String[] keyArr = keys.split(",");
        for (String s : keyArr) {
            log.debug("PushService.push(),Enter as:{}", msg);
            StringBuilder append = new StringBuilder("http://")
                    .append(barkServerUrl)
                    .append("/")
                    .append(s)
                    .append("/")
                    .append(msg);
            log.debug("Request connection as:{}", append);
            String resStr = HttpUtil.get(append.toString());
            log.debug(resStr);
        }
    }
}
