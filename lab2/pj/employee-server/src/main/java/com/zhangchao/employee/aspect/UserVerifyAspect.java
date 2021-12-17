package com.zhangchao.employee.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhangchao
 * @date 2021/10/18
 */
@Aspect
@Component
public class UserVerifyAspect {
    @Pointcut("execution(public * com.zhangchao.employee.controller.*.*(..))" +
            "&& !execution(public * com.zhangchao.employee.controller.HelloController.say(..))")
    public void verify() {
    }

    @Before("verify()")
    public void doVerify(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        System.out.println("Before invocation: URL " + request.getRequestURL());
        System.out.println("Before invocation: " + joinPoint.getSignature().toString());
    }

    @After("verify()")
    public void afterInvocation(JoinPoint joinPoint) {
        System.out.println("After invocation: " + joinPoint.getSignature().toString());
    }
}