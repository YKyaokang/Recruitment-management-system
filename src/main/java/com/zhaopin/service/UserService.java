package com.zhaopin.service;

import com.zhaopin.model.dto.LoginDTO;
import com.zhaopin.model.entity.User;

public interface UserService {
    User login(LoginDTO loginDTO);
    User register(User user);
    void logout(Long userId);
    User getUserById(Long id);
    User getUserByUsername(String username);
} 