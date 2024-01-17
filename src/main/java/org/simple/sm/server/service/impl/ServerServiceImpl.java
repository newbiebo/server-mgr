package org.simple.sm.server.service.impl;

import cn.hutool.core.date.DateUtil;
import org.simple.sm.common.base.BaseResultDTO;
import org.simple.sm.server.dto.res.ServerInfoResDTO;
import org.simple.sm.server.service.ServerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

@Service
public class ServerServiceImpl implements ServerService {

    @Value("${env.servermgr.version}")
    private String version;

    @Override
    public BaseResultDTO<ServerInfoResDTO> getServerInfo() {
        BaseResultDTO baseResultDTO = new BaseResultDTO();
        ServerInfoResDTO serverInfoResDTO = new ServerInfoResDTO();
        serverInfoResDTO.setVersion(version);
        // get system run time
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        long uptime = runtimeMXBean.getUptime();
        serverInfoResDTO.setRunTime(DateUtil.secondToTime((int) uptime / 1000));
        baseResultDTO.success(serverInfoResDTO);
        return baseResultDTO;
    }
}
