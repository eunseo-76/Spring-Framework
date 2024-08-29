package com.kenny.section03.annotationconfig.subsection01.java;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration("configurationSection03")  // 이 클래스가 설정 파일이다.
// 베이스 패키지 설정이 별도로 없을 경우 현재 패키지 기준으로 스캔이 수행된다.
@ComponentScan(basePackages = "com.kenny")  // 컴포넌트를 스캔하되, base package를 기준으로 하위의 모든 클래스 중 @Component가 있는 걸 스캔해라.
// Component = 이 클래스를 스캔해서 bean으로 등록해라. (MemberDAO)
public class ConfigurationContext {
}
