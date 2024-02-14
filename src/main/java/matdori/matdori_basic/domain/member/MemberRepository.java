package matdori.matdori_basic.domain.member;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

//implement crud
@Repository
public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; //member 생성 시 연속으로 id 할당

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findByMemberId(Long MemberId) {
        Member member = store.get(MemberId);
        return member;
    }

    public ArrayList<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public Optional<Member> findByLoginId(String loginId) {
        return findAll().stream()
                .filter(member -> member.getLoginId().equals(loginId))
                .findFirst();
    }

    public void deleteMember(Long MemberId) {
        store.remove(MemberId);
    }

    public void clearAllMember() {
        store.clear();
    }
}
