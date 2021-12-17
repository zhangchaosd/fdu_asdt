package com.zhangchao.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.zhangchao.employee.config.EmployeeProperties;

import javax.annotation.Resource;

/**
 * @author zhangchao
 * @date 2021/02/07
 */
@RestController
public class HelloController {

    @Resource
    private EmployeeProperties employeeProperties;

    @GetMapping(value = "/hello")
    public String hello() {
        return "age: " + employeeProperties.getAge() + " grade: " + employeeProperties.getGrade();
    }

    @RequestMapping(value = "/{age}/say/{username}", method = RequestMethod.GET)
    public String say(@PathVariable("age") Integer age, @PathVariable("username") String username) {
        return "age: " + age + " username: " + username;
    }

    @GetMapping(value = "/say")
    public String say2(@RequestParam(value = "age", required = false, defaultValue = "0") Integer result,
                       @RequestParam(value = "username", defaultValue = "boy") String username) {
        return "age: " + result + " username " + username;
    }
}
