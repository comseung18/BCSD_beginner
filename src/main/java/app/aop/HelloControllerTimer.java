package app.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class HelloControllerTimer {

    // app.controller 하위 패키지에 이름이 hello 로 시작하고 매개변수가 0개 이상인 모든 메서드에 대한 포인트 컷
    @Around("execution(* app.controller..*.hello*(..))")
    public void logHelloControllerExeTime(ProceedingJoinPoint joinPoint) throws Throwable
    {
        // 함수 호출전 시간을 기록
        long beforeTime = System.currentTimeMillis();
        joinPoint.proceed();
        long afterTime = System.currentTimeMillis();

        System.out.println(String.format("%s method execute time( ms ) : %d", joinPoint.getSignature().toShortString(), afterTime - beforeTime));
    }
}
