package com.zhaopin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhaopin.mapper.UserMapper;
import com.zhaopin.model.dto.LoginDTO;
import com.zhaopin.model.entity.User;
import com.zhaopin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(LoginDTO loginDTO) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", loginDTO.getUsername());
        User user = userMapper.selectOne(queryWrapper);
        
        if (user != null && user.getPassword().equals(DigestUtils.md5DigestAsHex(loginDTO.getPassword().getBytes()))) {
            return user;
        }
        return null;
    }

    @Override
    public User register(User user) {
        // 检查用户名是否已存在
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", user.getUsername());
        if (userMapper.selectOne(queryWrapper) != null) {
            return null;
        }

        // 加密密码
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        userMapper.insert(user);
        return user;
    }

    @Override
    public void logout(Long userId) {
        // 由于是简单的登录系统，这里不需要特殊处理
    }

    @Override
    public User getUserById(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public User getUserByUsername(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        return userMapper.selectOne(queryWrapper);
    }
} 