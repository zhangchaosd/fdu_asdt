package com.zhangchao.taskCompletion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.zhangchao.taskCompletion.entity.TaskCompletion;

import java.util.List;

/**
 * @author zhangchao
 * @date 2021/12/17
 */
@Repository
public interface TaskCompletionRepository extends JpaRepository<TaskCompletion, Integer> {
    List<TaskCompletion> findTaskCompletionByUserid(Integer userid);
    List<TaskCompletion> findTaskCompletionByCategory(Integer category);
    List<TaskCompletion> findTaskCompletionByUseridAndCategory(Integer userid, Integer category);
}
