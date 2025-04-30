package kr.ink94.gallery.member.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "MEMBERS")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "NAME", nullable = false, length = 50)
    private String name;

    @Column(name = "LOGIN_ID", nullable = false, length = 50)
    private String loginId;

    @Column(name = "LOGIN_PW", nullable = false, length = 100)
    private String loginPw;

    @Column(name = "CREATED", nullable = false)
    @CreationTimestamp
    private LocalDateTime created;

    public Member() {
    }

    public Member(String name, String loginId, String loginPw) {
        this.name = name;
        this.loginId = loginId;
        this.loginPw = loginPw;
    }
}