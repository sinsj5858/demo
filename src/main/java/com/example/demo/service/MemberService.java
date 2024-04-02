package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Transactional  //jpa 주의사항 트랜잭션이있어야함 (데이터 저장,변경 할때) (여기선 Join)
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member) { //회원가입
        validatefDuplicateMember(member); //중복회원검증
        memberRepository.save(member);
        return member.getId();
    }

    public Member login(String loginId, String password){
            return memberRepository.findByLoginId(loginId)
                    .filter(m -> m.getPassword().equals(password))
                    .orElse(null);
    }//return null이면 실패


    private void validatefDuplicateMember(Member member) {  ///중복회원검증
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}
