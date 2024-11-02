package hello.hello_spring.repository;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import hello.hello_spring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

// MemoryMemberRepository 테스트 케이스
// 순서 의존적으로 설정 x
class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 각 메소드 호출 후 실행
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    // save 메소드 테스트
    @Test
    public void save() {
        // 멤버 생성
        Member member = new Member();
        member.setName("spring");

        // 저장소에 저장
        repository.save(member);

        // 저장소에서 id로 찾아서 꺼내오기
        Member result = repository.findById(member.getId()).get();

        // 생성한 멤버와 저장소의 멤버가 같은지 확인
        // System.out.println("result = " + (result == member));

        Assertions.assertEquals(member, result); // result이 member와 같은지 확인 (기대하는 거, 비교할 거)

        org.assertj.core.api.
                Assertions.assertThat(member).isEqualTo(result); // member가 result와 같은지 확인

    }

    // findByName 메소드 테스트
    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        // Optional에서 get으로 name=spring1인 멤버 꺼내옴
        Member result = repository.findByName("spring1").get();

        org.assertj.core.api.
                Assertions.assertThat(result).isEqualTo(member1);
    }

    // findAll 메소드 테스트
    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        // 저장된 멤버들을 리스트에 저장
        List<Member> result = repository.findAll();

        // 리스트의 크기가 2인지 확인
        org.assertj.core.api.
                Assertions.assertThat(result.size()).isEqualTo(2);
    }

}
