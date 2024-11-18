package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

// GET : 서버에서 값을 가져올 때

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    // 출력할 메세지를 Appender에 전달할 Logger 객체 정의
    private final Logger LOGGER = LoggerFactory.getLogger(GetController.class);

    // http://localhost:8080/api/v1/get-api/hello
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello() {
        LOGGER.info("getHello 메서드가 호출되었습니다.");
        return "Hello World";
    }

    // http://localhost:8080/api/v1/get-api/name
    @GetMapping(value = "/name")
    public String getName() {
        LOGGER.info("getName 메서드가 호출되었습니다.");
        return "Flature";
    }

    // http://localhost:8080/api/v1/get-api/variable1/{String 값}
    // @PathVariable로 매개변수를 받음
    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable) {
        LOGGER.info("@PathVariable 통해 들어온 값: {}", variable);
        return variable;
    }

    // http://localhost:8080/api/v1/get-api/request1?name=value1&email=value2&organization=value3
    // @RequestParam로 매개변수 전달
    @GetMapping(value = "/request1")
    public String getRuquestParam1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization) {
        return name + " " + email + " " + organization;
    }

    // http://localhost:8080/api/v1/get-api/request2?key1=value1&key2=value
    // @RequestParam로 매개변수 전달 + Map 활용
    // 매개변수의 항목이 일정하지 않을 때
    @GetMapping(value = "/request2")
    public String getRuquestParam2(
            @RequestParam Map<String, String> param) {
                StringBuilder sb = new StringBuilder();
                // entrySet() : param 에 저장된 모든 키-값 쌍(엔트리)을 Set<Map.Entry<K, V>> 형태로 반환
                param.entrySet().forEach(map -> {
                    sb.append(map.getKey() + " : " + map.getValue() + "\n");
                });
        return sb.toString();
    }

    // http://localhost:8080/api/v1/get-api/request3?name=value1&email=value2&organization=value3
    // DTO 객체 활용
    @GetMapping(value = "/request3")
    public String getRuquestParam3(MemberDto memberDto) {
        // memberDto 정보 차례대로 나열해서 출력
        return memberDto.toString();
    }
}
