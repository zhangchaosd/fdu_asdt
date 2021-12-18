package com.zhangchao.taskCompletion.entity;

/**
 * @author zhangchao
 * @date 2021/12/18
 */
public class TaskCompletion {
    private String department;
    private Integer completed;
    private Integer total;

    public TaskCompletion() {
        completed = 0;
        total = 0;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getCompleted() {
        return completed;
    }

    public void setCompleted(Integer completed) {
        this.completed = completed;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public void completeOne() {
        completed += 1;
    }
}
