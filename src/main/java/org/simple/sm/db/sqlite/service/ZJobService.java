package org.simple.sm.db.sqlite.service;

import org.simple.sm.quartz.dto.job.ExecutableBackupJob;
import org.simple.sm.quartz.dto.job.ExecutableJob;

import java.util.List;

public interface ZJobService {

    List<ExecutableBackupJob> getBuckupJobList();
    List<ExecutableJob> getBarkJobList();

}
