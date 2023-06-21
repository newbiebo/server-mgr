package org.simple.sm.server.controller;

import lombok.extern.slf4j.Slf4j;
import org.simple.sm.server.dto.res.ServerInfoResDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("server")
public class ServerController {

    @GetMapping("get_server_info")
    public ServerInfoResDTO getServerInfo(){

        ServerInfoResDTO serverInfoResDTO = new ServerInfoResDTO();
        serverInfoResDTO.setVersion("1.1.1");

        return serverInfoResDTO;
    }
}
