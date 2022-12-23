CREATE DATABASE student_boot CHARACTER SET UTF-8;
USE student_boot;
DROP TABLE IF EXISTS manager;
CREATE TABLE `manager`(
    `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
    `user_name` varchar(50) not null comment '用户名',
    `pwd` varchar(50) not null comment '密码',
    primary key (`id`)
) ENGINE=InnoDB default CHARSET=utf8 comment '管理员表';
insert into manager(user_name,pwd) values ('admin','123456');

DROP TABLE IF EXISTS student;
CREATE TABLE `student`(
    `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
    `no` varchar(50) not null comment '学号',
    `real_name` varchar(50) not null comment '学生姓名',
    `enroll_time` datetime not null default current_timestamp comment '密码',
    primary key (`id`)
    unique key `uk_no` (`no`) using BTREE
) ENGINE=InnoDB default CHARSET=utf8 comment '学生表';

DROP TABLE IF EXISTS score;
CREATE TABLE `score`(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `student_id` BIGINT not null comment '外键:student表的id',
    `exam_name` varchar(100) not null comment '考试名称',
    `cn_score` decimal(5,2) default null comment '语文成绩',
    `en_score` decimal(5,2) default null comment '英语成绩',
    `math_score` decimal(5,2) default null comment '数学成绩',
    primary key (`id`)
) ENGINE=InnoDB default CHARSET=utf8 comment '成绩表';
