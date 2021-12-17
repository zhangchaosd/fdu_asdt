package com.zhangchao.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.zhangchao.employee.entity.Employee;

import java.util.List;

/**
 * @author zhangchao
 * @date 2021/03/29
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findEmployeeByUsername(String username);
}
