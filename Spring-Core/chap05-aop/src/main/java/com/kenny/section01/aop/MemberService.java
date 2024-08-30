package com.kenny.section01.aop;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MemberService {
    // 변경될 소지가 없도록 final 사용
    private final MemberDAO memberDAO;
    // 생성자 주입 - 일반적으로 많이 쓴다. @autowired 안 써도 됨.
    public MemberService(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }
    public Map<Long, MemberDTO> selectMembers(){
        System.out.println("selectMembers 메소드 실행");
        return memberDAO.selectMembers();
    }
    public MemberDTO selectMember(Long id) {
        System.out.println("selectMember 메소드 실행");
        return memberDAO.selectMember(id);
    }
}
