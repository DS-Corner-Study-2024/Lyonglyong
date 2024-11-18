package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

// POST : 클라이언트가 서버에 리소스를 저장할 때

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

    // @RequestMapping 으로 구현
    @RequestMapping(value = "/domain", method = RequestMethod.POST)
    public String postExample() {
        return "Hello Post API";
    }

    // http://localhost:8080/api/v1/post-api/member
    // @RequestBody 활용 : HTTP Body 내용을 지정된 객체에 매핑
    @PostMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> postData) {
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    // http://localhost:8080/api/v1/post-api/member
    // MemberDto 의 멤버 변수를 요청 메시지의 키와 매핑해 값을 가져옴
    @PostMapping(value = "/member2")
    public String postMember2(@RequestBody MemberDto memberDto) {
        return memberDto.toString();
    }
}
