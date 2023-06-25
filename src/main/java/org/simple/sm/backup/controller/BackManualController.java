package org.simple.sm.backup.controller;

import lombok.extern.slf4j.Slf4j;
import org.simple.sm.backup.service.BackupService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("backup")
public class BackManualController {

    @Resource
    BackupService backupService;

    @GetMapping("files")
    public void getServerInfo(List<String> sourceFiles, String targetPath){
        backupService.backupFiles(sourceFiles, targetPath);
    }

    @GetMapping("path")
    public void backupPath(String sourcePath,String targetPath){
        backupService.backupPath(sourcePath, targetPath);
    }

    @GetMapping("after_compress")
    public void backupAfterCompress(List<String> sourceFiles,String targetPath){
        backupService.backupAfterCompress(sourceFiles, targetPath);
    }
}
