package com.zhangchao.employee.controller;

import org.springframework.web.bind.annotation.*;
import com.zhangchao.employee.entity.Employee;
import com.zhangchao.employee.service.EmployeeService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangchao
 * @date 2021/12/17
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

    @PostMapping(value = "/getEmployeeById")
    public Employee findById(@RequestBody Employee employee) {
        return employeeService.findById(employee.getId());
    }

    @PostMapping(value = "/getEmployeeByName")
    public List<Employee> findByName(@RequestBody Employee employee) {
        return employeeService.findByName(employee.getName());
    }

    @PostMapping(value = "/getemployeebydepartment")
    public List<Employee> findByDepartment(@RequestBody Employee employee) {
        return employeeService.findByDepartment(employee.getDepartment());
    }

    @PostMapping(value = "/editEmployee")
    public Employee editEmployee(@RequestBody Employee employee) {
        return employeeService.update(employee);
    }
}
