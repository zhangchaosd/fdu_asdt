package com.zhangchao.user.service.impl;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.zhangchao.user.entity.User;
import com.zhangchao.user.entity.Result;
import com.zhangchao.user.repository.UserRepository;
import com.zhangchao.user.service.UserService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author zhangchao
 * @date 2021/12/17
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Integer id) {
        Optional<User> e = userRepository.findById(id);
        if(e.isPresent()){
            return e.get();
        }
        User bad = new User();
        bad.setId(-1);
        return bad;
    }

    @Override
    public User save(User user) {
        //TODO Send new user msg
        user.setPassword("123456");// TODO random
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        //TODO Send change password msg
        //TODO check id
        return userRepository.save(user);
    }

    public Result login(User user) {
        Result res = new Result();
        Optional<User> correctUser = userRepository.findById(user.getId());
        if((correctUser.isPresent()) && correctUser.get().getPassword().equals(user.getPassword())) {
            res.setMessage("success");
        }
        else {
            res.setMessage("wrong username or password");
        }
        return res;
    }
}
