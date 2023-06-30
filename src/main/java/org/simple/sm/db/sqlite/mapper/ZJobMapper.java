package org.simple.sm.db.sqlite.mapper;

import org.simple.sm.quartz.dto.job.ExecutableBackupJob;
import org.simple.sm.quartz.dto.job.ExecutableJob;

import java.util.List;

public interface ZJobMapper {
    List<ExecutableBackupJob> getBackupJobList();

    List<ExecutableJob> getBarkJobList();

}
