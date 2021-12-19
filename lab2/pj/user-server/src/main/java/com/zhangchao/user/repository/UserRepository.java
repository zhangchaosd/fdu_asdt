package com.zhangchao.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.zhangchao.user.entity.User;

/**
 * @author zhangchao
 * @date 2021/12/17
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserById(Integer id);
}
