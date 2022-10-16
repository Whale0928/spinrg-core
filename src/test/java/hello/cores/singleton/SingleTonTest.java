package hello.cores.singleton;

import hello.cores.AppConfig;
import hello.cores.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SingleTonTest {

    @Test
    @DisplayName("순수 DI 컨테이너")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();
        // 1. 호출할때마다 객체 생성하는지 조회

        MemberService ms1 = appConfig.memberService();
        MemberService ms2 = appConfig.memberService();

        System.out.println("ms1 = " + ms1);
        System.out.println("ms2 = " + ms2);
        //새로운 객체가 새로 생성되서 JVM메모리에 올라간다.

        assertThat(ms1).isNotEqualTo(ms2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singleTonServiceTest(){
        SingleTonService singleTonService1 = SingleTonService.getInstance();
        SingleTonService singleTonService2 = SingleTonService.getInstance();

        System.out.println("singleTonService1 = " + singleTonService1);
        System.out.println("singleTonService2 = " + singleTonService2);
//        singleTonService1 = hello.cores.singleton.SingleTonService@c0c2f8d
//        singleTonService2 = hello.cores.singleton.SingleTonService@c0c2f8d

        assertThat(singleTonService1).isSameAs(singleTonService2);
    }
}
