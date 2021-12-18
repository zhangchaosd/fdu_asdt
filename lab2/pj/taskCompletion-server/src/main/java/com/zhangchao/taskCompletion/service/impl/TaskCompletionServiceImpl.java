package com.zhangchao.taskCompletion.service.impl;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.zhangchao.taskCompletion.entity.TaskCompletion;
// import com.zhangchao.taskCompletion.entity.Result;
import com.zhangchao.taskCompletion.repository.TaskCompletionRepository;
import com.zhangchao.taskCompletion.service.TaskCompletionService;

import javax.annotation.Resource;
import java.util.List;
// import java.util.Optional;

/**
 * @author zhangchao
 * @date 2021/12/17
 */
@Service
public class TaskCompletionServiceImpl implements TaskCompletionService {
    @Resource
    TaskCompletionRepository taskCompletionRepository;

    @Override
    public List<TaskCompletion> findAll() {
        return taskCompletionRepository.findAll();
    }

    @Override
    public List<TaskCompletion> findByUserid(Integer userid) {
        return taskCompletionRepository.findTaskCompletionByUserid(userid);
    }

    @Override
    public List<TaskCompletion> findByCategory(Integer category) {
        return taskCompletionRepository.findTaskCompletionByCategory(category);
    }

    @Override
    public List<TaskCompletion> findByUseridAndCategory(Integer userid, Integer category) {
        return taskCompletionRepository.findTaskCompletionByUseridAndCategory(userid, category);
    }

    @Override
    public TaskCompletion save(String userid) {
        TaskCompletion taskCompletion = new TaskCompletion();
        taskCompletion.setUserid(Integer.parseInt(userid));
        taskCompletion.setCategory(1);
        taskCompletion.setCompleted(false);
        return taskCompletionRepository.save(taskCompletion);
    }

    @Override
    public TaskCompletion complete(String userid, Integer category) {
        List<TaskCompletion>taskCompletions = taskCompletionRepository.findTaskCompletionByUseridAndCategory(Integer.parseInt(userid), category);
        TaskCompletion taskCompletion = taskCompletions.get(0);
        taskCompletion.setCompleted(true);
        return taskCompletionRepository.save(taskCompletion);
    }
}
