package com.kenny.common;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/* 컴포넌트 스캔을 통해 bean으로 등록될 수 있도록 함 */
// ioc 컨테이너가 스캔하여 beand으로 등록함
@Component
public class MemberDAO {

    private final Map<Integer, MemberDTO> memberMap;

    public MemberDAO() {
        memberMap = new HashMap<>();
        memberMap.put(1, new MemberDTO(1, "user01", "pass01", "홍길동"));
        memberMap.put(2, new MemberDTO(2, "user02", "pass02", "유관순"));
    }

    public MemberDTO selectMember(int sequence) {
        return memberMap.get(sequence);
    }

    public boolean insertMember(MemberDTO member) {

        int before = memberMap.size();

        memberMap.put(member.getSequence(), member);

        int after = memberMap.size();

        return after > before;  // 똑같은 값이 들어가면 안 들어감
    }

}