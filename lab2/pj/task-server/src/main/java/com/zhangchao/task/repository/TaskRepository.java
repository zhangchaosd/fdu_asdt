package com.zhangchao.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.zhangchao.task.entity.Task;

import java.util.List;

/**
 * @author zhangchao
 * @date 2021/12/17
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findTaskByUserid(Integer userid);
    List<Task> findTaskByCategory(Integer category);
    List<Task> findTaskByUseridAndCategory(Integer userid, Integer category);
}
