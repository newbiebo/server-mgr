--
CREATE TABLE "t_quartz_info"
(
    id           integer not null
        primary key,
    job_no       text    not null,
    job_name     text    not null,
    job_group    text    not null,
    expression   text    not null,
    key          text    not null,
    url          text    not null,
    client       text    not null,
    is_delete    integer not null,
    gmt_create   TEXT    not null,
    gmt_modified TEXT    not null
);