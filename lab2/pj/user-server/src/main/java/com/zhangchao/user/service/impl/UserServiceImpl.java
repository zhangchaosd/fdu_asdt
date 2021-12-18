package com.zhangchao.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
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

    @Autowired
    private KafkaTemplate kafkaTemplate;

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
    public User save(String id) {
        kafkaTemplate.send("newUser", id);
        User user = new User();
        user.setId(Integer.parseInt(id));
        user.setPassword(getPsw(8));
        //TODO send EMAIL
        System.out.println("工号和密码:");
        System.out.println(Integer.toString(user.getId()));
        System.out.println(user.getPassword());
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        //TODO check id
        kafkaTemplate.send("passwordChanged", Integer.toString(user.getId()));
        return userRepository.save(user);
    }

    @Override
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

    public String getPsw(int len) {
        // 1、定义基本字符串baseStr和出参password
        String baseStr = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ~!@#$%^&*()_+{}|<>?";
        StringBuilder password = null;
    
        // 2、使用循环来判断是否是正确的密码
        boolean flag = false;
        while (!flag) {
            // 密码重置
            password = new StringBuilder();
            // 个数计数
            int a = 0,b = 0,c = 0,d = 0;
            for (int i = 0; i < len; i++) {
                int rand = (int) (Math.random() * baseStr.length());
                password.append(baseStr.charAt(rand));
                if (rand < 10) {
                    a++;
                }
                if (10 <= rand && rand < 36) {
                    b++;
                }
                if (36 <= rand && rand < 62) {
                    c++;
                }
                if (62 <= rand) {
                    d++;
                }
            }
            // 3、判断是否是正确的密码（4类中仅一类为0，其他不为0）
            flag = (a * b * c != 0 && d == 0) || (a * b * d != 0 && c == 0)
                    || (a * c * d != 0 && b == 0) || (b * c * d != 0 && a == 0);
        }
        return password.toString();
    }
}
