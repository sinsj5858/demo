package com.example.demo.domain;

import jakarta.persistence.*;

@Entity    //jpa가 관리하는 객체표시
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)       //pk, id자동생성
    private Long id;

    private String loginId;

    private String name;

    private String password;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
