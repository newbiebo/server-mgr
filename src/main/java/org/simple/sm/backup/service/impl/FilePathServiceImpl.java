package org.simple.sm.backup.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.simple.sm.backup.dto.req.FilePathReqDTO;
import org.simple.sm.backup.dto.res.FilePathResDTO;
import org.simple.sm.backup.service.FilePathService;
import org.simple.sm.common.base.BaseResultDTO;
import org.simple.sm.common.constant.ConstantSymbol;
import org.simple.sm.common.enumeration.ENUM_BASE_RESULT;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class FilePathServiceImpl implements FilePathService {

    @Override
    public BaseResultDTO<FilePathResDTO> filePathSearch(FilePathReqDTO filePathReqDTO) {
        BaseResultDTO<FilePathResDTO> resultDTO = new BaseResultDTO<>();
        FilePathResDTO filePathResDTO = new FilePathResDTO();
        //Default root path
        if (StringUtils.isEmpty(filePathReqDTO.getPath())) {
            filePathReqDTO.setPath(ConstantSymbol.SINGLE_DIAGONAL_LINE);
        }
        List<String> list = new ArrayList<>();
        File directory = new File(filePathReqDTO.getPath());
        if (directory.exists() && directory.isDirectory()) {
            File[] folders = directory.listFiles(File::isDirectory);
            if (folders != null) {
                for (File folder : folders) {
                    list.add(folder.getName());
                }
            }
        } else {
            resultDTO.failure(ENUM_BASE_RESULT.FILE_PATH_ERR);
        }
        filePathResDTO.setPaths(list);
        resultDTO.success(filePathResDTO);
        return resultDTO;
    }
}
