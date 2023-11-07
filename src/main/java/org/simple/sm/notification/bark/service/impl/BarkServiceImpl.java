package org.simple.sm.notification.bark.service.impl;

import cn.hutool.http.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.simple.sm.notification.bark.service.BarkService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BarkServiceImpl implements BarkService {

    @Value("${env.bark.server.url}")
    private String barkServerUrl;
    @Value("#{'${env.bark.server.keys}'.split(',')}")
    private List<String> keys;

    @Override
    public void push(String group, String msg) {
        this.doPush(group,null,msg,null);
    }

    @Override
    public void push(String group, String title, String msg) {
        this.doPush(group,title,msg,null);
    }

    @Override
    public void push(String group, String title, String msg, String url) {
        this.doPush(group,title,msg,url);
    }

    private void doPush(String group, String title, String msg, String url){
        if (StringUtils.isEmpty(group)) {group = "default";}
        if (StringUtils.isEmpty(title)) {title = "new msg";}
        for (String s : keys) {
            log.debug("PushService.push(),Enter as:{}", msg);
            StringBuilder append = new StringBuilder("http://")
                    .append(barkServerUrl)
                    .append("/")
                    .append(s)
                    .append("/")
                    .append(title)
                    .append("/")
                    .append(msg);
            if (!StringUtils.isEmpty(group)) {append = append.append("?group=").append(group);}
            if (!StringUtils.isEmpty(url)) {append = append.append("?url=").append(url);}
            log.debug("Request connection as:{}", append);
            String resStr = HttpUtil.get(append.toString());
            log.debug(resStr);
        }
    }
}
