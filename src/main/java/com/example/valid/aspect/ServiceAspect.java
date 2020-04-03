package com.example.valid.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

@Aspect
@Component
public class ServiceAspect extends BaseAspect {
    @Pointcut("execution(* com.example.valid.service.ValidService.*(..))")
    public void exeMethod() {
    }

    @Around("exeMethod()")
    public Object around(ProceedingJoinPoint pjp) throws Exception {
        Object[] params = pjp.getArgs();
        try {
            this.paramValidate(params);
            return pjp.proceed();
        } catch (Throwable t) {
            Signature sig = pjp.getSignature();
            MethodSignature methodSignature = null;
            methodSignature = (MethodSignature) sig;
            Object target = pjp.getTarget();
            Method currentMethod = target.getClass().getMethod(methodSignature.getName(), methodSignature.getParameterTypes());
            return handleException(t, currentMethod, params);
        }
    }
}
