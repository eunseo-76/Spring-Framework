package com.kenny.section01.aop;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)    // CGLib 방식을 통해 proxy 생성
public class ContextConfiguration {

}

// aop 기능을 사용하기 위해
// 1. aspecjweaber 라이브러리 다운
// 2. aspectj 활성화시킴 - @EnableAspectJAutoProxy