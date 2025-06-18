package com.zhaopin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhaopin.model.entity.JobPost;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface JobPostMapper extends BaseMapper<JobPost> {
} 