package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;

import java.util.List;
import java.util.Optional;

// 회원 객체를 저장하는 저장소
public interface MemberRepository {

    // 회원을 저장하면 저장된 회원 반환
    Member save(Member member);

    // id로 회원을 찾음
    // Optional : null 감싸서 반환 처리
    Optional<Member> findById(Long id);

    // name으로 회원을 찾음
    Optional<Member> findByName(String name);

    // 저장된 모든 회원 리스트 반환
    List<Member> findAll();
}
