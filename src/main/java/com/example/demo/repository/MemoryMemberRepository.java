package com.example.demo.repository;

import com.example.demo.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {
    private static Map<Long, Member> store = new HashMap<>(); //Map은 인터페이스
    private static long sequence = 0L;   // Id 순서 1234,적용

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long Id) {      //Optional null이 생기지않게 따로처리함
        return Optional.ofNullable(store.get(Id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()        //stream데이터의 흐름 람다활용기술
                .filter(member -> member.getName().equals(name))
                .findAny(); //맞는값을 리턴

    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());  //맵타입을 List방식으로 변환
    }

    public void clearStore(){
        store.clear();
    }
}
