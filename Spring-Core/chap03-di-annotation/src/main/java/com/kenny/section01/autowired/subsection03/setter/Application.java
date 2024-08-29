package com.kenny.section01.autowired.subsection03.setter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.kenny.section01");
        // 이 경로를 base package로 해서 component scan 해서 만드는 ioc 컨테이너를 만들겠다.
        // 따라서 BookDAOImpl도 스캔이 된다.

        BookService bookService = applicationContext.getBean("bookServiceSetter", BookService.class);

        bookService.selectAllBooks().forEach(System.out::println);
        System.out.println(bookService.searchBookBySequence(1));

        // @Autowired 가 없어도 null pointer exception 발생 안 함.
        // Spring 4.3 버전 이후부터 생성자가 1개 뿐이라면 어노테이션을 생략해도 자동으로 생성자 주입이 작동한다.
        // 단, 생성자가 1개 이상인 경우에는 명시적으로 작성해주어야 한다.
    }
}
