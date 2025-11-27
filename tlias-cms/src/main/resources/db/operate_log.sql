CREATE TABLE operate_log
(
    id             INT UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT 'ID',
    operate_emp_id INT UNSIGNED COMMENT '操作人ID',
    operate_time   DATETIME COMMENT '操作时间',
    class_name     VARCHAR(100) COMMENT '操作的类名',
    method_name    VARCHAR(100) COMMENT '操作的方法名',
    method_params  VARCHAR(2000) COMMENT '方法参数',
    return_value   VARCHAR(2000) COMMENT '返回值',
    cost_time      BIGINT UNSIGNED COMMENT '方法执行耗时，单位:ms'
) COMMENT ='操作日志表';