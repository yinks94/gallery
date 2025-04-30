package kr.ink94.gallery.member.service;

import kr.ink94.gallery.member.entity.Member;

public interface MemberService {
    void save(String name, String loginId, String loginPw);

    Member find(String loginId, String loginPw);
}
