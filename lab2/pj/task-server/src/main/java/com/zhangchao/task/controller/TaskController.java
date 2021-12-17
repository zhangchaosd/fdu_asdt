package com.zhangchao.task.controller;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.zhangchao.task.entity.Task;
// import com.zhangchao.task.entity.Result;
import com.zhangchao.task.service.TaskService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangchao
 * @date 2021/12/17
 */
@RestController
//@CrossOrigin(origins = "*",maxAge = 3600)
public class TaskController {
    @Resource
    TaskService taskService;

    @PostMapping(value = "/gettasksbyuserid")
    public List<Task> getTasksByUserid(@RequestBody Task task) {
        return taskService.findByUserid(task.getUserid());
    }

    @PostMapping(value = "/gettasksbycategory")
    public List<Task> getTasksByCategory(@RequestBody Task task) {
        return taskService.findByCategory(task.getCategory());
    }

    @PostMapping(value = "/gettasksbyuseridandcategory")
    public List<Task> getTasksByUseridAndCategory(@RequestBody Task task) {
        return taskService.findByUseridAndCategory(task.getUserid(), task.getUserid());
    }

    @PostMapping(value = "/completetask")
    public Task completeTask(@RequestBody Task task) {
        // TODO callback
        return taskService.complete(task);
    }

    @PostMapping(value = "/test1")
    public Task addNew(@RequestBody Task task) {
        // TODO callback
        return taskService.save(task);
    }

    @GetMapping(value = "/tasks") //TODO delete
    public List<Task> findAll() {
        return taskService.findAll(); //only for test
    }
}
