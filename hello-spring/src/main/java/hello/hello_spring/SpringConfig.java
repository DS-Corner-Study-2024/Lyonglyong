package hello.hello_spring;

import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import hello.hello_spring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    // MemberService 생성 후 스프링 빈에 등록
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    // MemberRepository 생성 후 스프링 빈에 등록
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
