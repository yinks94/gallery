package kr.ink94.gallery.account.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountJoinRequest {
    private String name;
    private String loginId;
    private String loginPw;
}
