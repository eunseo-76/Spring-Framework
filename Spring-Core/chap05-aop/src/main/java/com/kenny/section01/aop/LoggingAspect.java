package com.kenny.section01.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Map;

// Aspect : advice + point-cut
// advice : 부가 코드
// point-cut : 부가코드 적용 위치
@Component
@Aspect // point-cut과 advice를 하나의 클래스 단위로 정의하기 위한 어노테이션
public class LoggingAspect {

    // Pointcut: 여러 Join Point를 매치하기 위해 지정한 표현식 - 스프링 aop는 해당 메소드가 호출되는 시점에만 부가 코드 삽입 가능
    // 표현식 : 패키지명.클래스.메소드명(매개변수)
    @Pointcut("execution(* com.kenny.section01.aop.*Service.*(..))")    // MemberService의 모든 메소드
    public void logPointcut() {
    }

    // Advice : 부가 코드
    // Before : 핵심 기능 수행 전 동작
    @Before("LoggingAspect.logPointcut()")  // 클래스명.메소드명 - 위의 표현식을 그대로 가져온 것과 같음.
    public void logBefore(JoinPoint joinPoint) {    // JoinPoint : 포인트 컷으로 패치한 실행 시점
        // JoinPoint 객체를 통해 현재 조인 포인트의 메소드명, 인수 값 등 자세한 정보를 액세스 할 수 있다.
        System.out.println("before joinPoint.getTarget() : " + joinPoint.getTarget());
        System.out.println("before joinPoint.getSignature() : " + joinPoint.getSignature());
        if (joinPoint.getArgs().length > 0) {
            System.out.println("before joinPoint.getArgs()[0] : " + joinPoint.getArgs()[0]);
        }
    }

    // After : 핵심 기능 수행 후 동작 (정상 수행 또는 오류 발생 무관)
    @After("logPointcut()") // 포인트 컷을 클래스 내에서 사용할 경우 생략 가능, 패키지가 다르면 패키지명까지 기술.
    // 어떤 포인트컷에 이 advice를 삽입할 것인지 기술. 현재 같은 패키지의 같은 클래스이므로 생략
    public void logAfter(JoinPoint joinPoint) { // 어떤 메소드에 어떤 값을 가지고 접근했는지 알 수 있다.
        // JoinPoint 객체를 통해 현재 조인 포인트의 메소드명, 인수 값 등 자세한 정보를 액세스 할 수 있다.
        System.out.println("after joinPoint.getTarget() : " + joinPoint.getTarget());
        System.out.println("after joinPoint.getSignature() : " + joinPoint.getSignature());
        if (joinPoint.getArgs().length > 0) {
            System.out.println("after joinPoint.getArgs()[0] : " + joinPoint.getArgs()[0]);
        }
    }


    // AfterReturning -> 정상 수행 시
    @AfterReturning(pointcut = "logPointcut()", returning = "result")
    public void logAfterReturn(JoinPoint joinPoint, Object result) {
        System.out.println("after returning result : " + result);

        if (result != null && result instanceof Map<?, ?>) {
            ((Map<Long, MemberDTO>) result).put(100L, new MemberDTO(100L, "반환 값 가공"));
            // 결과 값을 가공해서 내보낸다. (result에 새로운 값을 넣어서 내보냄)
        }
    }
    // 정상 수행 된다면 해당 기능 수행 후 반환되는 값으로 가공, 처리가 가능하다.
    // 조인 포인트 + 반환값

    // AfterThrowing -> exception 발생 시
    @AfterThrowing(pointcut = "logPointcut()", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Exception exception) {
        System.out.println("after throwing exception : " + exception);
    }
    // 예외 발생 시 어떤 타입의 exception이 발생했는지 가져와 처리가 가능하다.
    // 조인 포인트 + 예외 타입
}



// selectMembers, selectMember는 포인트컷에 해당함.
// 각각을 호출할 때가 조인 포인트가 됨.

// 두 개의 기능을 호출하는데, 각각의 조인 포인트는 다름.
// taget이 누군지, signature가 뭔지, arg가 뭐가 넘어오는지 등을 물어볼 수 있다.
// 각각의 정보를 잘 가져와서 로깅하는지 확인.
