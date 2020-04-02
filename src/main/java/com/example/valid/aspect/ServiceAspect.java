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
        // pjp.getArgs=[InputParam{id=0, mobile='12'}]
        System.out.println("pjp.getArgs=" + Arrays.toString(params));
        try {
            this.paramValidate(params);
            return pjp.proceed();
        } catch (Throwable t) {
            Signature sig = pjp.getSignature();
            System.out.println("sig");
            // OutPutParam com.example.valid.service.ValidService.validTest(InputParam)
            System.out.println(sig.toString());
            // 1
            System.out.println(sig.getModifiers());
            // validTest
            System.out.println(sig.getName());
            // class com.example.valid.service.ValidService
            System.out.println(sig.getDeclaringType());
            MethodSignature methodSignature = null;
            methodSignature = (MethodSignature) sig;
            System.out.println(((MethodSignature) sig).getParameterTypes());
            Object target = pjp.getTarget();
            System.out.println("target");
            // com.example.valid.service.ValidService
            System.out.println(target.getClass().getName());
            Method currentMethod = target.getClass().getMethod(methodSignature.getName(), methodSignature.getParameterTypes());
            return handleException(t, currentMethod, params);
        }
    }
}
