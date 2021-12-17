package com.zhangchao.employee.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zhangchao
 * @date 2021/02/15
 */
@Component
@ConfigurationProperties(prefix = "employee")
public class EmployeeProperties {
    private String grade;
    private Integer age;

    public String getGrade() {
        return grade;
    }

    public Integer getAge() {
        return age;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
