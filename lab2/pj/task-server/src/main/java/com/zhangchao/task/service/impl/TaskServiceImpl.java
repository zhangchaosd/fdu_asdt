package com.zhangchao.task.service.impl;

import org.springframework.stereotype.Service;
import com.zhangchao.task.entity.Task;
import com.zhangchao.task.repository.TaskRepository;
import com.zhangchao.task.service.TaskService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangchao
 * @date 2021/12/17
 */
@Service
public class TaskServiceImpl implements TaskService {
    @Resource
    TaskRepository taskRepository;

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> findByUserid(Integer userid) {
        return taskRepository.findTaskByUserid(userid);
    }

    @Override
    public List<Task> findByCategory(Integer category) {
        return taskRepository.findTaskByCategory(category);
    }

    @Override
    public List<Task> findByUseridAndCategory(Integer userid, Integer category) {
        return taskRepository.findTaskByUseridAndCategory(userid, category);
    }

    @Override
    public Task save(String userid) {
        Task task = new Task();
        task.setUserid(Integer.parseInt(userid));
        task.setCategory(1);
        task.setCompleted(false);
        return taskRepository.save(task);
    }

    @Override
    public Task complete(String userid, Integer category) {
        List<Task>tasks = taskRepository.findTaskByUseridAndCategory(Integer.parseInt(userid), category);
        Task task = tasks.get(0);
        task.setCompleted(true);
        return taskRepository.save(task);
    }
}
