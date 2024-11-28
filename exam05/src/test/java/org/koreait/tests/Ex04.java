package org.koreait.tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.koreait.member.constants.Authority;
import org.koreait.member.entities.Member;
import org.koreait.member.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@SpringBootTest
@ActiveProfiles({"default", "test"})
public class Ex04 {
    @Autowired
    private MemberRepository repository;

    @BeforeEach
    void init() {
        Faker faker = new Faker(Locale.KOREA);
        List<Member> members = new ArrayList<>();

        for (int i = 0; i <= 10; i++) {
            Member member = new Member();
            member.setEmail(faker.internet().emailAddress());
            member.setPassword(faker.regexify("[a-zA-Z0-9],{8,16}"));
            member.setAuthority(Authority.USER);
            member.setName(faker.name().fullName());
            members.add(member);
        }

        repository.saveAllAndFlush(members);
    }

    @Test
    void test1() {
//        List<Member> members = repository.findByNameContainingOrderByRegDtDesc("김");
//        members.forEach(System.out::println);
//        0페이지, 한페이지당 3개씩
        Pageable pageable = PageRequest.of(0, 3);
        Page<Member> data = repository.findByNameContainingOrderByRegDtDesc("", pageable);

        List<Member> members = data.getContent();
        long total = data.getTotalElements();
        int pages = data.getTotalPages();

        members.forEach(System.out::println);
        System.out.printf("total=%d, pages=%d%n", total, pages);
    }

    @Test
    void test2() {
        Pageable pageable = PageRequest.of(1, 3);
        Page<Member> data = repository.findAll(pageable);
        List<Member> members = data.getContent();
        members.forEach(System.out::println);
    }
}