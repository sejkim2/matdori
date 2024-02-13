package matdori.matdori_basic.domain.member;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

//implement crud
@Repository
public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; //member 생성 시 연속으로 id 할당

    Member createMember(String loginId, String nickName, String password) {
        Member member = new Member(loginId, nickName, password);
        store.put(++sequence, member);
        return member;
    }

    void readMember(Long MemberId) {

    }

    void updateMember() {

    }

    void deleteMember() {

    }
}
