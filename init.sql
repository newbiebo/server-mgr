--任务详情表
CREATE TABLE "t_quartz_info"
(
    id           integer not null
        primary key,
    job_no       text    not null,--job号
    job_name     text    not null,--job名称
    job_group    text    not null,--job组
    job_type     text    not null,--job类型
    expression   text    not null,--cron表达式
    status       text    not null,--任务状态
    gmt_create   datetime    not null,--创建时间
    gmt_modified datetime    not null,--修改时间
    is_delete    integer not null--逻辑删除
);
--bark推送详情表
CREATE TABLE "t_bark_info"
(
    id           integer not null --主键
        primary key,
    job_no       text    not null,--任务号
    bark_no      text    not null,--bark推送号
    client       text    not null,--推送设备，ENUM_USER_CLIENT
    url          text    not null,--推送url
    type         text    not null,--推送类型，参考枚举：ENUM_BARK_TYPE
    gmt_create   datetime    not null,--创建时间
    gmt_modified datetime    not null,--修改时间
    is_delete    integer not null--逻辑删除
);
--备份详情表
CREATE TABLE "t_backup_info"
(
    id            integer not null --主键
        primary key,
    job_no        text    not null,--任务号
    backup_no     text    not null,--备份唯一id
    resource_path text    not null,--源路径，文件或文件路径
    target_path   text    not null,--目标路径
    gmt_create    datetime    not null,--创建时间
    gmt_modified  datetime    not null,--修改时间
    is_delete     integer not null--逻辑删除
);
--任务处理历史表
CREATE TABLE "t_quartz_history"
(
    id           integer not null
        primary key,
    job_no       text    not null,--任务号
    behavior_no  text    not null,--行为no
    behavior     text    not null,--行为，参考枚举：ENUM_QUARTZ_BEHAVIOR
    gmt_create   datetime    not null,--创建时间
    gmt_modified datetime    not null,--修改时间
    is_delete    integer not null--逻辑删除
);
CREATE TABLE "t_backup_history"
(
    id                integer not null  --主键
        primary key,
    job_no            text    not null,--任务号
    type              text    not null,--备份类型，参考枚举：ENUM_BACKUP_TYPE
    backup_history_no text    not null,--备份历史唯一id
    resource_path     text    not null,--源路径，文件或文件路径
    target_path       text    not null,--目标路径
    gmt_create        TEXT    not null,--创建时间
    gmt_modified      TEXT    not null,--修改时间
    is_delete         integer DEFAULT 0--逻辑删除
);
