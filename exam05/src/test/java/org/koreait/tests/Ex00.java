package org.koreait.tests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;

import java.util.Locale;

@SpringBootTest
public class Ex00 {

    @Autowired
    private MessageSource ms;

    @Test
    void test1() {
        String email = ms.getMessage("이메일", null, Locale.KOREAN);
        String email2 = ms.getMessage("Email", null, Locale.ENGLISH);
        System.out.println(email);
        System.out.println(email2);
    }
}
