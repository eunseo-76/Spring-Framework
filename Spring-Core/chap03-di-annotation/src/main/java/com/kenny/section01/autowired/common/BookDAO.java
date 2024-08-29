package com.kenny.section01.autowired.common;
// DAO = Data Access Obejct 데이터에 접근하는 객체 (실습의 repository와 유사)
// DB의 CRUD 작업을 할 때 사용.

import java.util.List;

public interface BookDAO {
    /* 도서 목록 전체 조회 */
    List<BookDTO> selectBookList();
    /* 도서 번호로 도서 조회 */
    BookDTO selectOneBook(int sequence);
}