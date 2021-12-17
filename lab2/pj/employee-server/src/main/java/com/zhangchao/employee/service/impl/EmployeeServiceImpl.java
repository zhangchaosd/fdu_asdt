package com.zhangchao.employee.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.zhangchao.employee.entity.Employee;
import com.zhangchao.employee.repository.EmployeeRepository;
import com.zhangchao.employee.service.EmployeeService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangchao
 * @date 2021/03/29
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }
}
