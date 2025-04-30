package kr.ink94.gallery.account.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ink94.gallery.account.dto.AccountJoinRequest;
import kr.ink94.gallery.account.dto.AccountLoginRequest;
import kr.ink94.gallery.account.helper.AccountHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class AccountController {
    private final AccountHelper accountHelper;

    @PostMapping("/api/account/join")
    public ResponseEntity<?> join(@RequestBody AccountJoinRequest joinRequest){
        if( !StringUtils.hasText(joinRequest.getName())
                || !StringUtils.hasText(joinRequest.getLoginId())
                || !StringUtils.hasText(joinRequest.getLoginPw()) ){
            return ResponseEntity.badRequest().build();
        }

        accountHelper.join(joinRequest);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/api/account/login")
    public ResponseEntity<?> login(HttpServletRequest request,
                                   HttpServletResponse response,
                                   @RequestBody AccountLoginRequest loginRequest){
        if( !StringUtils.hasText(loginRequest.getLoginId())
                || !StringUtils.hasText(loginRequest.getLoginPw()) ){
            return ResponseEntity.badRequest().build();
        }

        String loginId = accountHelper.login(loginRequest, request, response);
        if( loginId == null ){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/api/account/check")
    public ResponseEntity<?> check(HttpServletRequest request){
        return ResponseEntity
                .ok(accountHelper.isLogin(request));

    }

    @PostMapping("/api/account/logout")
    public ResponseEntity<?> logout(HttpServletRequest request, HttpServletResponse response){
        accountHelper.logout(request, response);
        return ResponseEntity.ok().build();
    }

}
