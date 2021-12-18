package com.zhangchao.taskCompletion.entity;

/**
 * @author zhangchao
 * @date 2021/12/18
 */
public class Employee {
    private Integer id;
    private String name;
    private String department;

    public Employee() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
