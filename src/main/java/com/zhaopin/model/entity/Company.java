package com.zhaopin.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("company")
public class Company {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String companyName;
    private String phone;
    private String address;
    private String description;
    private String industry;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
} 