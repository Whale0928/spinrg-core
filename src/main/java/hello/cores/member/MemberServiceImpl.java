package hello.cores.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;
    // ' 세미 콜론 까지 자동 완성 커맨드 + 쉬프트 엔터'

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트용
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
