package hello.hello_spring.controller;

import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    // 컨트롤러 생성 시, 컨트롤러와 서비스를 자동 연결
    // 서비스 객체를 자동으로 넣어줌 (DI)
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
