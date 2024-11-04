package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;


public class MemoryMemberRepository implements MemberRepository {

    // 회원을 저장하는 Map (id, 멤버)
    private static Map<Long, Member> store = new HashMap<>();

    // 키값을 생성 (0, 1, 2 ...)
    // 시스템이 자동 설정
    private static long sequence = 0L;

    // 멤버 저장
    @Override
    public Member save(Member member) {
        // 멤버 id 설정
        member.setId(++sequence);

        // store에 저장
        store.put(member.getId(), member);

        return member;
    }

    // id로 멤버 찾기
    @Override
    public Optional<Member> findById(Long id) {
        // Optional : null 반환 가능성 있을때 사용
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream() // 루프로 돌림
                .filter(member -> member.getName().equals(name)) // 멤버의 name이 파라미터로 넘어온 name과 같은지 확인, 같을 경우 필터링
                .findAny(); // 하나 찾으면 반환
    }

    @Override
    public List<Member> findAll() {
        // store의 values(Member) 담아서 반환
        return new ArrayList<>(store.values());
    }

    // Map을 비우기
    public void clearStore() {
        store.clear();
    }
}
