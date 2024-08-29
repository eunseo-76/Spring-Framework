package com.kenny.section03.annotationconfig.subsection01.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigurationContext.class);

        // 어떤 bean이 생성되었는지 확인
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println("beanName : " + beanName);
        }
    }
}
