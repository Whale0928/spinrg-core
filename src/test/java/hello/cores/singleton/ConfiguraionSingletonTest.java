package hello.cores.singleton;

import hello.cores.AppConfig;
import hello.cores.member.MemberRepository;
import hello.cores.member.MemberServiceImpl;
import hello.cores.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfiguraionSingletonTest{

    @Test
    void coonfigurationTest(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl ms = ac.getBean(MemberServiceImpl.class);
        OrderServiceImpl os = ac.getBean(OrderServiceImpl.class);


        MemberRepository  memberService = ms.getMemberRepository();
        MemberRepository  orderService = os.getMemberRepository();

        MemberRepository realMemberRepository = ac.getBean(MemberRepository.class);

        System.out.println("memberService = " + memberService);
        System.out.println("orderService = " + orderService);
        System.out.println("realMemberRepository = " + realMemberRepository);

        Assertions.assertThat(memberService).isSameAs(orderService).isSameAs(realMemberRepository);
    }

}
