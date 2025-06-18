package com.zhaopin.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@TableName("job_seeker")
public class JobSeeker {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String gender;
    private LocalDate birthDate;
    private String contact;
    private String hometown;
    private String education;
    private String major;
    private String degree;
    private String school;
    private String skills;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
} 