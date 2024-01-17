package org.simple.sm.backup.service;

import org.simple.sm.backup.dto.req.FilePathReqDTO;
import org.simple.sm.backup.dto.res.FilePathResDTO;
import org.simple.sm.common.base.BaseResultDTO;

import java.util.List;

public interface FilePathService {

    /**
     * Server path query
     * @return File directory
     */
    BaseResultDTO<FilePathResDTO> filePathSearch(FilePathReqDTO filePathReqDTO);

}
