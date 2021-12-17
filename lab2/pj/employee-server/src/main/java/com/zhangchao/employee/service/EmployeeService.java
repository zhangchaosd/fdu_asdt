package com.zhangchao.employee.service;

import com.zhangchao.employee.entity.Employee;

import java.util.List;

/**
 * @author zhangchao
 * @date 2021/03/29
 */
public interface EmployeeService {
    List<Employee> findAll();
    Employee save(Employee employee);
}
