package kr.ink94.gallery.member.service;

import kr.ink94.gallery.member.entity.Member;
import kr.ink94.gallery.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BaseMemberService implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public void save(String name, String loginId, String loginPw) {
        Member member = new Member(name, loginId, loginPw);
        memberRepository.save(member);
    }

    @Override
    public Member find(String loginId, String loginPw) {
        return memberRepository.findByLoginIdAndLoginPw(loginId, loginPw)
                .orElse(null);
    }
}
