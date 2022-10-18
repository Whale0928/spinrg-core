package hello.cores.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long,Member> store  = new HashMap<>();
    //HashMap == 동시성 여부 발생 가능성 높음

    @Override //회원 저장을 위한 메서드
    public void save(Member member) {
        store.put(member.getId(),member);
    }

    @Override //회원 탐색을 위한 메서드
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
