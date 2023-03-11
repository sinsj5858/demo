package com.example.demo;

import com.example.demo.aop.TimeTraceAop;
import com.example.demo.repository.*;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
//    private DataSource dataSource;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }                                         //jdbc와 jdbc템플릿에 사용

//    private EntityManager em;
//    @Autowired                                //jpa 사용
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }
    private final MemberRepository memberRepository;

    @Autowired  //객체하나일때는 생략가능
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){               //스프링 데이터 jpa DB기술일때 사용
        return new MemberService(memberRepository);
    }

//    @Bean
//    public TimeTraceAop timeTraceAop(){
//        return new TimeTraceAop();
//    }

//    @Bean
//    public MemberService memberService(){             //스프링 데이터 jpa 이외의 DB 기술일때 사용
//        return new MemberService(memberRepository());
//    }

//    @Bean
//    public MemberRepository memberRepository(){       /스프링 데이터 jpa 이외의 DB 기술일때 사용
//
//        //return new MemoryMemberRepository();
//        //return new JdbcMemberRepository(dataSource);
//        //return new JdbcTemplateMemberRepository(dataSource);
//        //return new JpaMemberRepository(em);
//    }




}
