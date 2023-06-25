package org.simple.sm.server.service.impl;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import org.simple.sm.config.EnvProperties;
import org.simple.sm.server.dto.res.ServerInfoResDTO;
import org.simple.sm.server.service.ServerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

@Service
public class ServerServiceImpl implements ServerService {

    @Resource
    EnvProperties envProperties;

    @Override
    public ServerInfoResDTO getServerInfo() {
        ServerInfoResDTO serverInfoResDTO = new ServerInfoResDTO();
        serverInfoResDTO.setVersion(envProperties.getVersion());
        // get system run time
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        long uptime = runtimeMXBean.getUptime();
        serverInfoResDTO.setRunTime(DateUtil.secondToTime((int) uptime / 1000));
        return serverInfoResDTO;
    }
}
