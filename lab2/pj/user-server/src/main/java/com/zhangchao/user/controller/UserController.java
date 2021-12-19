package com.zhangchao.user.controller;

import org.springframework.web.bind.annotation.*;
import com.zhangchao.user.entity.User;
import com.zhangchao.user.entity.Result;
import com.zhangchao.user.service.UserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangchao
 * @date 2021/12/17
 */
@RestController
//@CrossOrigin(origins = "*",maxAge = 3600)
public class UserController {
    @Resource
    UserService userService;

    @PostMapping(value = "/login")
    public Result login(@RequestBody User user) {
        return userService.login(user);
    }

    @PostMapping(value = "/changepassword")
    public User changePassword(@RequestBody User user) {
        return userService.update(user);
    }

    @GetMapping(value = "/users")
    public List<User> findAll() {
        return userService.findAll(); //only for test
    }
}
