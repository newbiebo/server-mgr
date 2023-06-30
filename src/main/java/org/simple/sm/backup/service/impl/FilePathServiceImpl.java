package org.simple.sm.backup.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.simple.sm.backup.dto.req.FilePathReqDTO;
import org.simple.sm.backup.dto.res.FilePathResDTO;
import org.simple.sm.backup.service.FilePathService;
import org.simple.sm.common.base.BaseResultDTO;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class FilePathServiceImpl implements FilePathService {

    @Override
    public FilePathResDTO filePathSearch(FilePathReqDTO filePathReqDTO) {
        //Default root path
        if (StringUtils.isEmpty(filePathReqDTO.getPath())) {
            filePathReqDTO.setPath("/");
        }
        ArrayList<String> list = new ArrayList<>();
        File directory = new File(filePathReqDTO.getPath());
        if (directory.exists() && directory.isDirectory()) {
            File[] folders = directory.listFiles(File::isDirectory);
            if (folders != null) {
                for (File folder : folders) {
                    list.add(folder.getName());
                }
            }
        } else {
            log.info("The specified path does not exist or is not a folder.");
        }
        return FilePathResDTO.builder().paths(list).build();
    }
}
