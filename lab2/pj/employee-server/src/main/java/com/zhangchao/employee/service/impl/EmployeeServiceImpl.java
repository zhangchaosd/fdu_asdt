package com.zhangchao.employee.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.zhangchao.employee.entity.Employee;
import com.zhangchao.employee.repository.EmployeeRepository;
import com.zhangchao.employee.service.EmployeeService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author zhangchao
 * @date 2021/12/17
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    EmployeeRepository employeeRepository;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        Optional<Employee> e = employeeRepository.findById(id);
        if(e.isPresent()){
            return e.get();
        }
        Employee bad = new Employee();
        bad.setId(-1);
        return bad;
    }

    @Override
    public List<Employee> findByName(String name) {
        return employeeRepository.findEmployeeByName(name);
    }

    @Override
    public List<Employee> findByDepartment(String department) {
        return employeeRepository.findEmployeeByDepartment(department);
    }

    @Override
    public Employee save(Employee employee) {
        kafkaTemplate.send("newEmployee", Integer.toString(employee.getId()));
        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return employeeRepository.save(employee);
    }
}
