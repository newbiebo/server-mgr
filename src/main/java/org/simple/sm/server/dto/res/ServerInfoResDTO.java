package org.simple.sm.server.dto.res;

import lombok.Data;

@Data
public class ServerInfoResDTO {

    /**
     * Current service version number
     */
    private String version;
    /**
     * System running time
     */
    private String runTime;

}
