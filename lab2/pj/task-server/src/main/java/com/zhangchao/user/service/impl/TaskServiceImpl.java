package com.zhangchao.task.service.impl;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.zhangchao.task.entity.Task;
import com.zhangchao.task.entity.Result;
import com.zhangchao.task.repository.TaskRepository;
import com.zhangchao.task.service.TaskService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

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
    public Task save(Task task) {
        //TODO Send new task msg
        return taskRepository.save(task);
    }

    @Override
    public Task complete(Task task) {
        task.setComplete(true);
        return taskRepository.save(task);
    }
}
