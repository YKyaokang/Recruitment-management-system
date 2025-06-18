package com.zhaopin.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("resume_delivery")
public class ResumeDelivery {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long jobSeekerId;
    private Long jobPostId;
    private String status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
} 