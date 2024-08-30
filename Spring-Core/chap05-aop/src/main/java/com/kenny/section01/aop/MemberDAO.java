package com.kenny.section01.aop;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

// repo 지만 실제 db와의 연결은 x, 메모리에 저장
// selectMembers 요청이 오면 관리되고 있는 member Map을 반환
// selectMember 요청이 오면 해당하는 member 반환
@Repository
public class MemberDAO {
    private final Map<Long, MemberDTO> memberMap;
    public MemberDAO(){
        memberMap = new HashMap<>();
        memberMap.put(1L, new MemberDTO(1L, "유관순"));
        memberMap.put(2L, new MemberDTO(2L, "홍길동"));
    }
    public Map<Long, MemberDTO> selectMembers(){
        return memberMap;
    };
    public MemberDTO selectMember(Long id) {
        MemberDTO returnMember = memberMap.get(id);
        if(returnMember == null) throw new RuntimeException("해당하는 id의 회원이 없습니다.");
        return returnMember;
    }
}