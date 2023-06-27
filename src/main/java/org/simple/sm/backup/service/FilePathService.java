package org.simple.sm.backup.service;

import org.simple.sm.backup.dto.req.FilePathReqDTO;

import java.util.List;

public interface FilePathService {

    /**
     * Server path query
     * @return File directory
     */
    List<String> filePathSearch(FilePathReqDTO filePathReqDTO);

}
