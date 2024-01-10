package org.simple.sm.backup.dto.res;

import lombok.Builder;
import lombok.Data;
import org.simple.sm.common.base.BaseResultDTO;

import java.util.List;

@Data
public class FilePathResDTO extends BaseResultDTO {
    private List<String> paths;
}
