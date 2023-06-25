package org.simple.sm.backup.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("path")
public class FilePathController {

    @GetMapping("files")
    public void getServerInfo(List<String> sourceFiles, String targetPath){
        backupService.backupFiles(sourceFiles, targetPath);
    }

}
