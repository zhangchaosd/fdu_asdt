package com.zhangchao.taskCompletion.entity;

/**
 * @author zhangchao
 * @date 2021/12/17
 */
public class Task {
    private Integer taskid;

    private Integer userid;
    private Integer category;
    private boolean completed;

    public Task() {
    }

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
