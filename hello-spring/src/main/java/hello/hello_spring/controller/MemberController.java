package hello.hello_spring.controller;

import hello.hello_spring.domain.Member;
import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    // 컨트롤러 생성 시, 컨트롤러와 서비스를 자동 연결
    // 서비스 객체를 자동으로 넣어줌 (DI)
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 회원 가입 화면으로 이동
    // /members/new로 이동 시, createMemberForm.html 호출
    // Get: url에 직접 치는 방식
    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    // <form> action에서 넘어옴
    @PostMapping("/members/new")
    public String create(MemberForm form) {
        // 멤버 객체 생성 후, form에서 name 가져와 주입
        Member member = new Member();
        member.setName(form.getName());

        // 회원 가입 로직 작동
        memberService.join(member);

        // 가입이 끝나면 홈 화면으로 보냄
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        // 멤버 리스트 모델에 담아 화면에 넘기기
        model.addAttribute("members", members);
        return "members/memberList";
    }

}
