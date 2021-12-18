package com.zhangchao.taskCompletion.controller;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.zhangchao.taskCompletion.entity.TaskCompletion;
import com.zhangchao.taskCompletion.service.TaskCompletionService;

import javax.annotation.Resource;

@Service
public class KafkaListenerService {
    @Resource
    TaskCompletionService taskCompletionService;

    @KafkaListener(topics = {"newUser"})
    public void listener0(String userid){
        taskCompletionService.save(userid);
    }

    @KafkaListener(topics = {"passwordChanged"})
    public void listener1(String userid){
        taskCompletionService.complete(userid, 1);
    }
}