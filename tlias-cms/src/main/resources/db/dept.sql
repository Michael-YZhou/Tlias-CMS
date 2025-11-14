DROP TABLE IF EXISTS dept;

create table if not exists dept
(
    id          int unsigned auto_increment comment 'ID, 主键' primary key,
    name        varchar(10) not null comment '部门名称',
    create_time datetime    null comment '创建时间',
    update_time datetime    null comment '修改时间',
    constraint name unique (name)
) comment '部门表';

INSERT INTO dept
VALUES (1, '工学部', '2024-09-25 09:47:40', '2024-09-25 09:47:40'),
       (2, '教研部', '2024-09-25 09:47:40', '2024-09-25 09:47:40'),
       (3, '咨询部', '2024-09-25 09:47:40', '2024-09-25 09:47:40'),
       (4, '就业部', '2024-09-25 09:47:40', '2024-09-25 09:47:40'),
       (5, '人事部', '2024-09-25 09:47:40', '2024-09-25 09:47:40'),
       (6, '行政部', '2024-11-30 20:56:37', '2024-09-30 20:56:37');