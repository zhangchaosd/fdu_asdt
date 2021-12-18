package com.zhangchao.user.controller;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.zhangchao.user.service.UserService;

import javax.annotation.Resource;

@Service
public class KafkaListenerService {
    @Resource
    UserService userService;

    @KafkaListener(topics = {"newEmployee"})
    public void listener(String id){
        userService.save(id);
    }
}
