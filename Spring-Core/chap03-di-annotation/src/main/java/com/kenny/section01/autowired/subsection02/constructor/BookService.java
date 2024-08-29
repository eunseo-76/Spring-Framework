package com.kenny.section01.autowired.subsection02.constructor;

import com.kenny.section01.autowired.common.BookDAO;
import com.kenny.section01.autowired.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// @Component의 세분화 어노테이션으로 Service 계층에서 사용한다.
@Service("bookServiceConstructor")    // 이 클래스 타입의 bean이 등록된다. (스캔 범위 안에 있어야 함)
public class BookService {

    private BookDAO bookDAO;    // bookdao를 의존하는 클래스 bookservice
    // private BookDAO bookDAO = new BookDAOImpl(); 이렇게 쓰지 않기 위해 의존성 주입을 하려는 것이다.
    // ioc 컨테이너가 알아서 의존성 주입을 하게 해야한다. 그를 위해 Autowired 사용한다.

//    public BookService() {} // 이렇게 생성자가 2개가 되면 @autowired 생략 시 오류 발생할 수 있다
    // 생성자 주입
    // Spring 4.3 버전 이후부터 생성자가 1개 뿐이라면 어노테이션을 생략해도 자동으로 생성자 주입이 작동한다.
    // 단, 생성자가 1개 이상인 경우에는 명시적으로 작성해주어야 한다.
    @Autowired
    public BookService(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }
    public List<BookDTO> selectAllBooks() {
        return bookDAO.selectBookList();
    }

    public BookDTO searchBookBySequence(int sequence) {
        return bookDAO.selectOneBook(sequence);
    }
}
