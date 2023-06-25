package org.simple.sm.backup.service;

import java.util.List;

public interface FilePathService {

    /**
     * Server path query
     * @return File directory
     */
    List<String> filePathSearch(String path);

}
