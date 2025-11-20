create table emp_log
(
    id           int unsigned auto_increment comment 'ID, 主键' primary key,
    operate_time datetime      null comment '操作时间',
    info         varchar(2000) null comment '日志信息'
) comment '员工日志表';