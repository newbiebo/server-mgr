package org.simple.sm.backup.controller;

import lombok.extern.slf4j.Slf4j;
import org.simple.sm.backup.dto.req.BackupManualReqDTO;
import org.simple.sm.backup.service.BackupService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/backup")
public class BackupManualController {

    @Resource
    BackupService backupService;

    @PostMapping("/files")
    public void getServerInfo(@RequestBody BackupManualReqDTO backupManualReqDTO){
        backupService.backupFiles(backupManualReqDTO);
    }

    @PostMapping("path")
    public void backupPath(@RequestBody BackupManualReqDTO backupManualReqDTO){
        backupService.backupPath(backupManualReqDTO);
    }

    @PostMapping("after_compress")
    public void backupAfterCompress(@RequestBody BackupManualReqDTO backupManualReqDTO){
        backupService.backupAfterCompress(backupManualReqDTO);
    }
}
