package org.simple.sm.server.controller;

import lombok.extern.slf4j.Slf4j;
import org.simple.sm.server.dto.res.ServerInfoResDTO;
import org.simple.sm.server.service.ServerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("server")
public class ServerController {

    @Resource
    ServerService serverService;

    @GetMapping("get_server_info")
    public ServerInfoResDTO getServerInfo(){
        return serverService.getServerInfo();
    }
}
