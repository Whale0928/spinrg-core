package hello.cores;

import hello.cores.member.Gradle;
import hello.cores.member.Member;
import hello.cores.member.MemberService;

public class MemberApp {
    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberervice();

        Member member = new Member(1L, "memberA", Gradle.VIP);

        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName() );
    }
}
