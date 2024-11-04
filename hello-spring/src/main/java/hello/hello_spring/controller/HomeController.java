package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // 8080으로 접속하면, home.html 호출
    @GetMapping("/")
    public String home() {
        return "home";
    }
}
