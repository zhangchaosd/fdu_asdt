package com.zhangchao.taskCompletion.service;

import com.zhangchao.taskCompletion.entity.TaskCompletion;
// import com.zhangchao.taskCompletion.entity.Result;

import java.util.List;

/**
 * @author zhangchao
 * @date 2021/12/17
 */
public interface TaskCompletionService {
    List<TaskCompletion> findAll();
    List<TaskCompletion> findByUserid(Integer userid);
    List<TaskCompletion> findByCategory(Integer category);
    List<TaskCompletion> findByUseridAndCategory(Integer userid, Integer category);
    TaskCompletion save(String userid);
    TaskCompletion complete(String userid, Integer category);
}
