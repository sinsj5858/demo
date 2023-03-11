package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//스프링 데이터 jpa 사용시 자동으로 @Bean에 이파일을 등록해줌 그리고 기본CRUD(find,save 등등)기능을 가지고있음
public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long>,MemberRepository {  //인터페이스를 받을때는 extends

    @Override
    Optional<Member> findByName(String name);   //기본CRUD가 아닌 생성된 테이블임
}
