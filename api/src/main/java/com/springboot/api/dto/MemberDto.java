package com.springboot.api.dto;

// DTO : 다른 레이어 간 데이터 교환, 매개변수로 사용되는 데이터 객체
// 쿼리스트링의 키가 정해져 있지만 받을 파라미터가 많을 경우

public class MemberDto {

    private String name;
    private String email;
    private String organization;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getOrganization() {
        return organization;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @Override
    public String toString() {
        return "MemberDto{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", organization='" + organization + '\'' +
                '}';
    }
}
