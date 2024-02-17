package matdori.matdori_basic.domain.login;

import matdori.matdori_basic.domain.member.Member;
import matdori.matdori_basic.domain.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    private final MemberRepository memberRepository;

    @Autowired
    public LoginService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member login(String loginId, String password) {
        Optional<Member> memberOptional = memberRepository.findByLoginId(loginId);
        Member member = memberOptional.get();
        if (member.getPassword().equals(password))
            return member;
        else
            return null;
    }
}
