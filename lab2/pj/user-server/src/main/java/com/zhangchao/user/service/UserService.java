package com.zhangchao.user.service;

import com.zhangchao.user.entity.User;
import com.zhangchao.user.entity.Result;

import java.util.List;

/**
 * @author zhangchao
 * @date 2021/12/17
 */
public interface UserService {
    List<User> findAll();
    User findById(Integer id);
    User save(User user);
    User update(User user);

    Result login(User user);
}
