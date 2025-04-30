package kr.ink94.gallery.member.repository;

import kr.ink94.gallery.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    Optional<Member> findByLoginIdAndLoginPw(String loginId, String loginPw);
}
