package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

// PUT : 웹 애플리케이션 서버를 통해 저장소에 있는 리소스 값을 업데이트

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {

    // http://localhost:8080/api/v1/put-api/member
    // @RequestBody를 활용
    // Map: 서버에 어떤 값이 들어올지 모르는 경우
    @PutMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> putData) {
        StringBuilder sb = new StringBuilder();

        putData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    // http://localhost:8080/api/v1/put-api/member1
    // DTO: 서버에 들어오는 요청에 담겨 있는 값이 정해져 있는 경우
    // 클라이언트가 요청 본문에 JSON 데이터를 담아 보내면, MemberDto 객체로 변환하여 메서드 파라미터로 전달
    @PutMapping(value = "/member1")
    public String putMemberDto1(@RequestBody MemberDto memberDto) {
        return memberDto.toString();
    }

    // http://localhost:8080/api/v1/put-api/member2
    @PutMapping(value = "/member2")
    public MemberDto putMemberDto2(@RequestBody MemberDto memberDto) {
        return memberDto;
    }

    // http://localhost:8080/api/v1/put-api/member3
    // ResponseEntity<T> 활용 : <T>는 응답 본문(body)에 포함될 데이터의 타입
    // HTTP 응답의 상태 코드와 응답 본문을 포함한 응답을 클라이언트에 반환
    @PutMapping(value = "/member3")
    public ResponseEntity<MemberDto> postMember3(@RequestBody MemberDto memberDto) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED) // 응답 코드: 202 -> 이 메서드로 요청 수행하면 202로 변경
                .body(memberDto); // 응답 본문에 memberDto 객체 포함
    }
}