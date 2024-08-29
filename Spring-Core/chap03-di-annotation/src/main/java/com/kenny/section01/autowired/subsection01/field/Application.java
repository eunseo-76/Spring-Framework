package com.kenny.section01.autowired.subsection01.field;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.kenny.section01");
        // 이 경로를 base package로 해서 component scan 해서 만드는 ioc 컨테이너를 만들겠다.
        // 따라서 BookDAOImpl도 스캔이 된다.

        BookService bookService = applicationContext.getBean("bookServiceField", BookService.class);

        bookService.selectAllBooks().forEach(System.out::println);
        System.out.println(bookService.searchBookBySequence(1));

        // @Autowired 가 없으면 그냥 null이 된다.

        /* 필드 주입의 경우 IoC 컨테이너 없이 테스트 하려고 하면 bookDAO 의존성 주입이 불가능해서
        * 아래 코드 수행 시 NullPointerException이 발생한다 => 생성자 주입 권장 */

//        bookService.bookService2 = new BookService();
//        bookService2.selectAllBooks();
    }
}
