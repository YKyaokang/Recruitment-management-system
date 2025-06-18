-- 创建数据库
CREATE DATABASE IF NOT EXISTS zhaopin DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

USE zhaopin;

-- 企业基本信息表
CREATE TABLE IF NOT EXISTS company (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '企业编号',
    company_name VARCHAR(100) NOT NULL COMMENT '企业名称',
    phone VARCHAR(20) NOT NULL COMMENT '企业电话',
    address VARCHAR(200) NOT NULL COMMENT '企业地址',
    description TEXT COMMENT '企业简介',
    industry VARCHAR(100) COMMENT '经营行业',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT '企业基本信息表';

-- 求职者信息表
CREATE TABLE IF NOT EXISTS job_seeker (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '求职者编号',
    name VARCHAR(50) NOT NULL COMMENT '姓名',
    age INT COMMENT '年龄',
    gender VARCHAR(10) COMMENT '性别',
    birth_date DATE COMMENT '出生日期',
    contact VARCHAR(50) NOT NULL COMMENT '联系方式',
    hometown VARCHAR(200) COMMENT '户籍所在地',
    education VARCHAR(50) COMMENT '最后学历',
    major VARCHAR(100) COMMENT '专业',
    degree VARCHAR(50) COMMENT '学位',
    school VARCHAR(100) COMMENT '毕业学校',
    skills TEXT COMMENT '业务技能',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT '求职者信息表';

-- 招聘信息表
CREATE TABLE IF NOT EXISTS job_post (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '招聘信息编号',
    company_id BIGINT NOT NULL COMMENT '企业编号',
    company_name VARCHAR(100) NOT NULL COMMENT '企业名称',
    company_phone VARCHAR(20) NOT NULL COMMENT '企业电话',
    company_address VARCHAR(200) NOT NULL COMMENT '企业地址',
    position_name VARCHAR(100) NOT NULL COMMENT '岗位名称',
    requirements TEXT NOT NULL COMMENT '岗位要求',
    salary VARCHAR(50) NOT NULL COMMENT '岗位工资',
    headcount INT NOT NULL COMMENT '招聘人数',
    publish_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
    other_requirements TEXT COMMENT '其他要求',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    FOREIGN KEY (company_id) REFERENCES company(id)
) COMMENT '招聘信息表';

-- 简历投递表
CREATE TABLE IF NOT EXISTS resume_delivery (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '投递编号',
    job_seeker_id BIGINT NOT NULL COMMENT '求职者编号',
    job_post_id BIGINT NOT NULL COMMENT '招聘信息编号',
    status VARCHAR(20) DEFAULT 'PENDING' COMMENT '状态：PENDING-待处理，ACCEPTED-已录用，REJECTED-已拒绝',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    FOREIGN KEY (job_seeker_id) REFERENCES job_seeker(id),
    FOREIGN KEY (job_post_id) REFERENCES job_post(id)
) COMMENT '简历投递表';

-- 用户表（包含求职者、企业和管理员）
CREATE TABLE IF NOT EXISTS user (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '用户编号',
    username VARCHAR(50) NOT NULL UNIQUE COMMENT '用户名',
    password VARCHAR(100) NOT NULL COMMENT '密码',
    role VARCHAR(20) NOT NULL COMMENT '角色：JOB_SEEKER-求职者，COMPANY-企业，ADMIN-管理员',
    related_id BIGINT COMMENT '关联ID（求职者ID或企业ID）',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT '用户表'; 