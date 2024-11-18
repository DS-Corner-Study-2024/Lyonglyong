package com.springboot.api.controller;

import org.springframework.web.bind.annotation.*;

// DELETE : 웹 애플리케이션 서버를 거쳐 저장소에 있는 리소스를 삭제

@RestController
@RequestMapping("/api/v1/delete-api")
public class DeleteController {

    // http://localhost:8080/api/v1/delete-api/{String 값}
    // @PathVariable로 URL에 포함된 값 받아 처리
    @DeleteMapping(value = "/{variable}")
    public String Delete(@PathVariable String variable) {
        return variable;
    }

    // http://localhost:8080/api/v1/delete-api/request1?email=value
    @DeleteMapping(value = "/request1")
    public String getRequest1(@RequestParam String email) {
        return "email : " + email;
    }
}
