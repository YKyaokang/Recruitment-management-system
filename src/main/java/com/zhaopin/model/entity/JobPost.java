package com.zhaopin.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("job_post")
public class JobPost {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long companyId;
    private String companyName;
    private String companyPhone;
    private String companyAddress;
    private String positionName;
    private String requirements;
    private String salary;
    private Integer headcount;
    private LocalDateTime publishTime;
    private String otherRequirements;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
} 