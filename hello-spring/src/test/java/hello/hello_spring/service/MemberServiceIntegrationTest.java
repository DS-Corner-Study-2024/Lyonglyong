package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    void 회원가입() {
        // given (무언가 주어짐, 이 데이터 기반)
        // hello 이름 가진 멤버 객체
        Member member = new Member();
        member.setName("spring1");

        // when (이걸 실행했을 때, 검증하는 거)
        // 회원가입 서비스 실행
        Long saveId = memberService.join(member);

        // then (이게 나와야 해, 검증부)
        // member가 memberService로 회원가입이 됐는지
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    // 중복 회원 로직 예외 처리 검증
    @Test
    public void 중복_회원_예외() {
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);
        // memberService.join(member2)을 하면 IllegalStateException 예외가 터져야 함
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        // 예외 메세지 같은지 확인
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }
}