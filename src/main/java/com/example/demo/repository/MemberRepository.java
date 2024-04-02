package com.example.demo.repository;

import com.example.demo.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    //기능 등록(save),조회(id, name)
    Member save(Member member);
    Optional<Member> findById(Long Id);
    Optional<Member> findByName(String name);
    Optional<Member> findByLoginId(String loginId);

    Optional<Member> findByPassword(String password);
    List<Member> findAll();




}
