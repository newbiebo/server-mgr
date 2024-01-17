package org.simple.sm.db.sqlite.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.simple.sm.quartz.dto.job.ExecutableBackupJob;
import org.simple.sm.quartz.dto.job.ExecutableBarkJob;

import java.util.List;

@Mapper
public interface ZJobMapper {

    @Select("select m.job_no        as jobNo,\n" +
            "               m.job_name      as jobName,\n" +
            "               m.job_group     as jobGroup,\n" +
            "               m.expression    as expression,\n" +
            "               n.resource_path as resourcePath,\n" +
            "               n.target_path   as targetPath\n" +
            "        from t_quartz_info m\n" +
            "        left join t_backup_info n on n.job_no = m.job_no\n" +
            "        where n.is_delete = 0\n" +
            "          and m.is_delete = 0;")
    List<ExecutableBarkJob> getBarkJobList();

//    List<ExecutableBackupJob> getBackupJobList();

}
