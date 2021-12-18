package com.zhangchao.task.controller;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.zhangchao.task.entity.Task;
import com.zhangchao.task.service.TaskService;

import javax.annotation.Resource;

@Service
public class KafkaListenerService {
    @Resource
    TaskService taskService;

    @KafkaListener(topics = {"newUser"})
    public void listener0(String userid){
        taskService.save(userid);
    }

    @KafkaListener(topics = {"passwordChanged"})
    public void listener1(String userid){
        taskService.complete(userid, 1);
    }
}