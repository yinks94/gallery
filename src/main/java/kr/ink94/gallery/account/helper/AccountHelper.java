package kr.ink94.gallery.account.helper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ink94.gallery.account.dto.AccountJoinRequest;
import kr.ink94.gallery.account.dto.AccountLoginRequest;

public interface AccountHelper {

    void join(AccountJoinRequest joinRequest);

    String login(AccountLoginRequest loginRequest, HttpServletRequest request, HttpServletResponse response);

    Integer getMemberId(HttpServletRequest request);

    boolean isLogin(HttpServletRequest request);

    void logout(HttpServletRequest request, HttpServletResponse response);

}
