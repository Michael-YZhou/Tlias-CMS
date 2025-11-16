# 员工表
drop table if exists emp;

create table if not exists emp
(
    id          int unsigned auto_increment comment 'ID,主键' primary key,
    username    varchar(20)                  not null comment '用户名',
    password    varchar(32) default '123456' null comment '密码',
    name        varchar(10)                  not null comment '姓名',
    gender      tinyint unsigned             not null comment '性别, 1:男, 2:女',
    phone       char(11)                     not null comment '手机号',
    job         tinyint unsigned             null comment '职位, 1 班主任, 2 讲师 , 3 学工主管, 4 教研主管, 5 咨询师',
    salary      int unsigned                 null comment '薪资',
    image       varchar(255)                 null comment '头像',
    entry_date  date                         null comment '入职日期',
    dept_id     int unsigned                 null comment '部门ID',
    create_time datetime                     null comment '创建时间',
    update_time datetime                     null comment '修改时间',
    constraint phone unique (phone),
    constraint username unique (username)
) comment '员工表';

INSERT INTO emp
(username, password, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time)
VALUES ('zhangsan', '123456', '张三', 1, '13800000001', 2, 12000, 'avatar1.jpg', '2022-03-15', 1, '2022-03-15 10:12:23',
        '2023-01-10 09:33:45'),
       ('lisi', '123456', '李四', 2, '13800000002', 1, 15000, 'avatar2.jpg', '2021-07-01', 2, '2021-07-01 09:01:11',
        '2022-02-14 14:22:10'),
       ('wangwu', '123456', '王五', 1, '13800000003', 2, 13000, 'avatar3.jpg', '2020-10-20', 1, '2020-10-20 08:45:00',
        '2021-05-18 16:42:35'),
       ('zhaoliu', '123456', '赵六', 1, '13800000004', 3, 16000, 'avatar4.jpg', '2019-05-10', 3, '2019-05-10 11:22:19',
        '2020-03-22 10:55:44'),
       ('sunqi', '123456', '孙七', 2, '13800000005', 4, 9000, 'avatar5.jpg', '2023-02-18', 4, '2023-02-18 13:14:52',
        '2023-09-03 15:30:18'),
       ('zhouba', '123456', '周八', 1, '13800000006', 4, 20000, 'avatar6.jpg', '2018-08-12', 2, '2018-08-12 17:33:00',
        '2019-04-18 11:20:41'),
       ('wujiu', '123456', '吴九', 2, '13800000007', 2, 12500, 'avatar7.jpg', '2023-04-01', 1, '2023-04-01 09:44:12',
        '2023-10-10 18:19:59'),
       ('zhengshi', '123456', '郑十', 1, '13800000008', 1, 11800, 'avatar8.jpg', '2022-01-30', 4, '2022-01-30 15:11:05',
        '2022-11-05 10:28:32'),
       ('miaohua', '123456', '苗花', 2, '13800000009', 4, 9800, 'avatar9.jpg', '2023-06-15', 3, '2023-06-15 10:10:10',
        '2023-12-01 08:55:23'),
       ('chengyu', '123456', '程宇', 1, '13800000010', 2, 14000, 'avatar10.jpg', '2020-09-25', 1, '2020-09-25 14:09:33',
        '2021-02-20 12:14:47'),
       ('yanglin', '123456', '杨林', 1, '13800000011', 3, 17000, 'avatar11.jpg', '2019-11-28', 2, '2019-11-28 10:00:00',
        '2020-10-12 16:55:19'),
       ('fanghua', '123456', '方华', 2, '13800000012', 4, 21000, 'avatar12.jpg', '2018-04-10', 4, '2018-04-10 12:23:45',
        '2019-02-03 17:40:12'),
       ('luna', '123456', '卢娜', 2, '13800000013', 3, 13300, 'avatar13.jpg', '2021-12-18', 3, '2021-12-18 10:18:58',
        '2022-09-09 13:31:21'),
       ('mengfei', '123456', '孟飞', 1, '13800000014', 1, 9200, 'avatar14.jpg', '2023-03-05', 4, '2023-03-05 09:09:09',
        '2023-11-20 19:10:05'),
       ('yuchen', '123456', '于晨', 1, '13800000015', 2, 13800, 'avatar15.jpg', '2022-05-22', 1, '2022-05-22 08:15:33',
        '2023-01-15 14:44:02'),
       ('gaoyu', '123456', '高瑜', 2, '13800000016', 1, 15200, 'avatar16.jpg', '2020-08-08', 2, '2020-08-08 10:10:22',
        '2021-06-17 11:25:30'),
       ('liming', '123456', '黎明', 1, '13800000017', 3, 16500, 'avatar17.jpg', '2019-10-10', 3, '2019-10-10 09:22:55',
        '2020-07-11 10:50:29'),
       ('xiaofang', '123456', '肖芳', 2, '13800000018', 4, 9100, 'avatar18.jpg', '2023-07-01', 4, '2023-07-01 11:33:12',
        '2023-11-09 17:48:56'),
       ('pengbo', '123456', '彭博', 1, '13800000019', 2, 12900, 'avatar19.jpg', '2021-02-15', 1, '2021-02-15 12:12:12',
        '2022-01-03 10:33:45'),
       ('anran', '123456', '安然', 2, '13800000020', 4, 20500, 'avatar20.jpg', '2018-09-23', 2, '2018-09-23 10:08:08',
        '2019-06-20 18:19:13');

# 员工工作经历信息
drop table if exists emp_expr;

create table if not exists emp_expr
(
    id      int unsigned auto_increment comment 'ID, 主键' primary key,
    emp_id  int unsigned null comment '员工ID',
    begin   date         null comment '开始时间',
    end     date         null comment '结束时间',
    company varchar(50)  null comment '公司名称',
    job     varchar(50)  null comment '职位'
) comment '工作经历';