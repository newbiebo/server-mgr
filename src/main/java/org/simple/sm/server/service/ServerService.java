package org.simple.sm.server.service;

import org.simple.sm.common.base.BaseResultDTO;
import org.simple.sm.server.dto.res.ServerInfoResDTO;

public interface ServerService {
    /**
     * get server info
     * @return
     */
    BaseResultDTO<ServerInfoResDTO> getServerInfo();
}
