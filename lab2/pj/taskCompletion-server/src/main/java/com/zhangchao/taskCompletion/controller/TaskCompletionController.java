package com.zhangchao.taskCompletion.controller;

import org.springframework.web.bind.annotation.*;
import com.zhangchao.taskCompletion.entity.TaskCompletion;
import com.zhangchao.taskCompletion.service.TaskCompletionService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangchao
 * @date 2021/12/17
 */
@RestController
//@CrossOrigin(origins = "*",maxAge = 3600)
public class TaskCompletionController {
    @Resource
    TaskCompletionService taskCompletionService;

    @PostMapping(value = "/gettaskCompletionsbyuserid")
    public List<TaskCompletion> getTaskCompletionsByUserid(@RequestBody TaskCompletion taskCompletion) {
        return taskCompletionService.findByUserid(taskCompletion.getUserid());
    }

    @PostMapping(value = "/gettaskCompletionsbycategory")
    public List<TaskCompletion> getTaskCompletionsByCategory(@RequestBody TaskCompletion taskCompletion) {
        return taskCompletionService.findByCategory(taskCompletion.getCategory());
    }

    @PostMapping(value = "/gettaskCompletionsbyuseridandcategory")
    public List<TaskCompletion> getTaskCompletionsByUseridAndCategory(@RequestBody TaskCompletion taskCompletion) {
        return taskCompletionService.findByUseridAndCategory(taskCompletion.getUserid(), taskCompletion.getUserid());
    }

    @GetMapping(value = "/taskCompletions") //TODO delete
    public List<TaskCompletion> findAll() {
        return taskCompletionService.findAll(); //only for test
    }
}
