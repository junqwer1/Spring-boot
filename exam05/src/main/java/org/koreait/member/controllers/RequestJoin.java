package org.koreait.member.controllers;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class RequestJoin {
    @Email
    @NotBlank
    private String email;

    @Size(min=8, max=20) // 8자리 이상 문자열
    @NotBlank
    private String password;

    @NotBlank
    private String confirmPassword;

    @NotBlank
    private String name;

    private String mobile; // 휴대전화 번호

    @AssertTrue
    private boolean agree; // 회원가입 약관 동의 여부
}
