package app.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class HelloControllerTimer {

    @Around("execution(* app.controller..*.hello*(..))")
    public void logHelloControllerExeTime(ProceedingJoinPoint joinPoint) throws Throwable
    {
        joinPoint.proceed();
    }
}
