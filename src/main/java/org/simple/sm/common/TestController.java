package org.simple.sm.common;

import org.simple.sm.external.bark.service.BarkService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/test")
@RestController
public class TestController {
    @Resource
    BarkService barkService;
    @GetMapping ("barkService/push")
    public void push(@RequestParam String msg){
        barkService.push("",msg);
    }
}
