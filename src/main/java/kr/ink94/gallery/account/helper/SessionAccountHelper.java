package kr.ink94.gallery.account.helper;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ink94.gallery.account.dto.AccountJoinRequest;
import kr.ink94.gallery.account.dto.AccountLoginRequest;
import kr.ink94.gallery.account.etc.AccountConstants;
import kr.ink94.gallery.common.util.HttpUtils;
import kr.ink94.gallery.member.entity.Member;
import kr.ink94.gallery.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SessionAccountHelper implements AccountHelper {

    private final MemberService memberService;

    @Override
    public void join(AccountJoinRequest joinRequest) {
       memberService.save(joinRequest.getName(), joinRequest.getLoginId(), joinRequest.getLoginPw());
    }

    @Override
    public String login(AccountLoginRequest loginRequest, HttpServletRequest request, HttpServletResponse response) {

        Member member = memberService.find(loginRequest.getLoginId(), loginRequest.getLoginPw());
        if( member == null){
            return null;
        }
        HttpUtils.setSession(request, AccountConstants.MEMBER_ID_NAME, member.getId());
        return member.getLoginId();
    }

    @Override
    public Integer getMemberId(HttpServletRequest request) {
        Object memberId = HttpUtils.getSessionValue(request, AccountConstants.MEMBER_ID_NAME);
        if( memberId == null ){
            return null;
        }
        return (Integer) memberId;
    }

    @Override
    public boolean isLogin(HttpServletRequest request) {
        return getMemberId(request) != null;
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        HttpUtils.removeSession(request, AccountConstants.MEMBER_ID_NAME);
    }
}
