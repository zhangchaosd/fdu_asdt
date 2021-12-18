package com.zhangchao.task.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;
import javax.persistence.Id;

/**
 * @author zhangchao
 * @date 2021/12/17
 */
@Entity
public class Task {
    @Id
    private Integer taskid;

    private Integer userid;
    private Integer category;
    private boolean completed;

    public Task() {
    }

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    public Integer getTaskid() {
        return taskid;
    }

    public void setTaskid(Integer taskid) {
        this.taskid = taskid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
