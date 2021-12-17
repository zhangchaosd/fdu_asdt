package com.zhangchao.employee.service;

import com.zhangchao.employee.entity.Employee;

import java.util.List;

/**
 * @author zhangchao
 * @date 2021/12/17
 */
public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(Integer id);
    List<Employee> findByName(String name);
    List<Employee> findByDepartment(String name);
    Employee save(Employee employee);
    Employee update(Employee employee);
}
