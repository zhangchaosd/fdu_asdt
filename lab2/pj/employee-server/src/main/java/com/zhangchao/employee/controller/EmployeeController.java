package com.zhangchao.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.zhangchao.employee.entity.Employee;
import com.zhangchao.employee.service.EmployeeService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangchao
 * @date 2021/03/29
 */
@RestController
//@CrossOrigin(origins = "*",maxAge = 3600)
public class EmployeeController {
    @Resource
    EmployeeService employeeService;

    @PostMapping(value = "/employees")
    public Employee addNew(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @GetMapping(value = "/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }
}
