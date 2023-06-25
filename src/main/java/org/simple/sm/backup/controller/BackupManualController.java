package org.simple.sm.backup.controller;

import lombok.extern.slf4j.Slf4j;
import org.simple.sm.backup.dto.req.BackupManualReqDTO;
import org.simple.sm.backup.service.BackupService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("backup")
public class BackupManualController {

    @Resource
    BackupService backupService;

    @GetMapping("files")
    public void getServerInfo(@RequestBody BackupManualReqDTO backupManualReqDTO){
        backupService.backupFiles(backupManualReqDTO);
    }

    @GetMapping("path")
    public void backupPath(@RequestBody BackupManualReqDTO backupManualReqDTO){
        backupService.backupPath(backupManualReqDTO);
    }

    @GetMapping("after_compress")
    public void backupAfterCompress(@RequestBody BackupManualReqDTO backupManualReqDTO){
        backupService.backupAfterCompress(backupManualReqDTO);
    }
}
