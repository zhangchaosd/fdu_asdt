package com.zhangchao.taskCompletion.entity;

/**
 * @author zhangchao
 * @date 2021/12/17
 */
public class Result {
    private String message;

    public Result() {
        this.message = "success";
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
