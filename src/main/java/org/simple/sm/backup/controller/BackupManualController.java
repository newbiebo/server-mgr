package org.simple.sm.backup.controller;

import lombok.extern.slf4j.Slf4j;
import org.simple.sm.backup.dto.req.BackupManualReqDTO;
import org.simple.sm.backup.dto.res.BackupManualResDTO;
import org.simple.sm.backup.dto.res.FilePathResDTO;
import org.simple.sm.backup.service.BackupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/backup")
public class BackupManualController {

    @Resource
    BackupService backupService;

    @PostMapping("/backupFiles")
    public ResponseEntity<BackupManualResDTO> backupFiles(@RequestBody BackupManualReqDTO backupManualReqDTO){
        return new ResponseEntity<>(backupService.backupFiles(backupManualReqDTO), HttpStatus.OK);
    }

    @PostMapping("/backupPath")
    public ResponseEntity<BackupManualResDTO> backupPath(@RequestBody BackupManualReqDTO backupManualReqDTO){
        return new ResponseEntity<>(backupService.backupPath(backupManualReqDTO), HttpStatus.OK);

    }

    @PostMapping("/backupAfterCompress")
    public ResponseEntity<BackupManualResDTO> backupAfterCompress(@RequestBody BackupManualReqDTO backupManualReqDTO){
        return new ResponseEntity<>(backupService.backupAfterCompress(backupManualReqDTO), HttpStatus.OK);
    }
}
