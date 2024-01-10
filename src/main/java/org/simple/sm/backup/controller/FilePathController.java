package org.simple.sm.backup.controller;

import lombok.extern.slf4j.Slf4j;
import org.simple.sm.backup.dto.req.FilePathReqDTO;
import org.simple.sm.backup.dto.res.FilePathResDTO;
import org.simple.sm.backup.service.FilePathService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/path")
public class FilePathController {

    @Resource
    FilePathService filePathService;

    @PostMapping("/getFilePath")
    public ResponseEntity<FilePathResDTO> getFilePath(@RequestBody FilePathReqDTO filePathReqDTO){
        return new ResponseEntity<>(filePathService.filePathSearch(filePathReqDTO), HttpStatus.OK);
    }
}
