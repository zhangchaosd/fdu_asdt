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

    @GetMapping(value = "/getTaskCompletions")
    public List<TaskCompletion> getTaskCompletions() {
        return taskCompletionService.getTaskCompletions();
    }
}
