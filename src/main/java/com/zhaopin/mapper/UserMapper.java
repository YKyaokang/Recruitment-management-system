package com.zhaopin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhaopin.model.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
} 