package org.koreait.member.exceptions;

import org.koreait.global.exceptions.CommonException;
import org.koreait.global.exceptions.scripts.AlertBackException;
import org.springframework.http.HttpStatus;

public class MemberNotFoundException extends AlertBackException {
    public MemberNotFoundException() {
        super("NotFound.member", HttpStatus.NOT_FOUND);
        setErrorcode(true);
    }
}
