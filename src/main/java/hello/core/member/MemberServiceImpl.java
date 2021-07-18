package hello.core.member;

public class MemberServiceImpl implements MemberService {

//    private MemberRepository memberRepository = new MemoryMemberRepository();
    private MemberRepository memberRepository; // 추상화에만 의존하게 된 거임.

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
}
