package com.zhangchao.taskCompletion.service;

import com.zhangchao.taskCompletion.entity.TaskCompletion;

import java.util.List;

/**
 * @author zhangchao
 * @date 2021/12/17
 */
public interface TaskCompletionService {
    List<TaskCompletion> getTaskCompletions();
}
