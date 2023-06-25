package org.simple.sm.backup.controller;

import lombok.extern.slf4j.Slf4j;
import org.simple.sm.backup.service.FilePathService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("path")
public class FilePathController {

    @Resource
    FilePathService filePathService;

    @PostMapping("files")
    public List<String> getFilePath(@PathVariable String path){
        return filePathService.filePathSearch(path);
    }
}
