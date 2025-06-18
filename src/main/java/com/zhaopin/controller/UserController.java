package com.zhaopin.controller;

import com.zhaopin.model.common.Result;
import com.zhaopin.model.dto.LoginDTO;
import com.zhaopin.model.entity.User;
import com.zhaopin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result<User> login(@RequestBody LoginDTO loginDTO) {
        User user = userService.login(loginDTO);
        if (user != null) {
            return Result.success(user);
        }
        return Result.error("用户名或密码错误");
    }

    @PostMapping("/register")
    public Result<User> register(@RequestBody User user) {
        User registeredUser = userService.register(user);
        if (registeredUser != null) {
            return Result.success(registeredUser);
        }
        return Result.error("用户名已存在");
    }

    @PostMapping("/logout")
    public Result<Void> logout(@RequestParam Long userId) {
        userService.logout(userId);
        return Result.success(null);
    }

    @GetMapping("/{id}")
    public Result<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return Result.success(user);
        }
        return Result.error("用户不存在");
    }
} 