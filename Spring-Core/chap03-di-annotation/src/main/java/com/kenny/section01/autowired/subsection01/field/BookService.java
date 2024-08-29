package com.kenny.section01.autowired.subsection01.field;

import com.kenny.section01.autowired.common.BookDAO;
import com.kenny.section01.autowired.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// @Component의 세분화 어노테이션으로 Service 계층에서 사용한다.
@Service("bookServiceField")    // 이 클래스 타입의 bean이 등록된다. (스캔 범위 안에 있어야 함)
public class BookService {

    // 필드 주입 <- 어노테이션을 필드 위에 붙인 것이다.
    @Autowired  // BookDAO 타입의 빈 객체를 이 프로퍼티에 자동으로 주입해준다.
    private BookDAO bookDAO;    // bookdao를 의존하는 클래스 bookservice
    // private BookDAO bookDAO = new BookDAOImpl(); 이렇게 쓰지 않기 위해 의존성 주입을 하려는 것이다.
    // ioc 컨테이너가 알아서 의존성 주입을 하게 해야한다. 그를 위해 Autowired 사용한다.
    public List<BookDTO> selectAllBooks() {
        return bookDAO.selectBookList();
    }

    public BookDTO searchBookBySequence(int sequence) {
        return bookDAO.selectOneBook(sequence);
    }
}
