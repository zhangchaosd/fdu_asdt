package com.zhangchao.task.service;

import com.zhangchao.task.entity.Task;
// import com.zhangchao.task.entity.Result;

import java.util.List;

/**
 * @author zhangchao
 * @date 2021/12/17
 */
public interface TaskService {
    List<Task> findAll();
    List<Task> findByUserid(Integer userid);
    List<Task> findByCategory(Integer category);
    List<Task> findByUseridAndCategory(Integer userid, Integer category);
    Task save(String userid);
    Task complete(String userid, Integer category);
}
