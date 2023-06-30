package org.simple.sm.db.sqlite.service.impl;

import org.simple.sm.common.enumeration.ENUM_JOB_NAME;
import org.simple.sm.db.sqlite.mapper.ZJobMapper;
import org.simple.sm.db.sqlite.service.ZJobService;
import org.simple.sm.quartz.dto.job.ExecutableBackupJob;
import org.simple.sm.quartz.dto.job.ExecutableJob;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class ZJobServiceImpl implements ZJobService {

    @Resource
    ZJobMapper zJobMapper;

    @Override
    public List<ExecutableBackupJob> getBuckupJobList() {
        List<ExecutableBackupJob> ExecutableBackupJob = zJobMapper.getBackupJobList();
        backupJobList.forEach(e->e.setType(ENUM_JOB_NAME.BACKUP_JOB.getValue()));
        return backupJobList;
    }
    @Override
    public List<ExecutableJob> getBarkJobList() {
        List<ExecutableJob> barkJobList = zJobMapper.getBarkJobList();
        return barkJobList;
    }
}
