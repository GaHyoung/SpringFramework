package com.nhnacademy.edu.springframework.messagesender;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect //AspectJ지원이 활성화 된 상태에서, Bean으로 선성하고 @Aspect 설정 시 이 스프링빈이 Aspect가 됨.
@Component
// advice -> Around, pointcut -> execution(...)
// advice : 특정 Join Point에서 Aspect가 취하는 행동
// Around : Join Point 앞과 뒤에서 실행되는 Advice
// execution : 메소드 실행 조인포인트와 매칭
public class MyStopWatch {

    @Pointcut("execution(public void com.nhnacademy.edu.springframework.messagesender.MessageSendService.doMessage(User, String)) && args(user, message)")
    public void messageSendService(User user, String message) {}

    @Around("messageSendService(user, message)")
    public Object printExecutionTime(ProceedingJoinPoint joinPoint, User user, String message) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        try{
            //Around Advice 는 JoinPoint의 서브클래스인 ProceedingJoinPoint 를 반드시 사용
            Object result = joinPoint.proceed();
            return result; //MessageSender method 실행
        }catch (Throwable e){
            System.out.println(e.getMessage());
            throw e;
        }finally {
            stopWatch.stop();
            System.out.println("Execution Time: " + stopWatch.getTotalTimeMillis() + " milliseconds");
        }
    }
}
