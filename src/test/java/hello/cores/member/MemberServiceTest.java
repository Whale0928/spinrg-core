package hello.cores.member;

import hello.cores.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void beferEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberervice();
    }


    @Test
    void join(){
        //Given
        Member member = new Member(1L,"memberA",Gradle.VIP);
        
        //When
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
