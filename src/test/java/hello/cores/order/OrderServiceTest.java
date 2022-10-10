package hello.cores.order;

import hello.cores.AppConfig;
import hello.cores.member.Gradle;
import hello.cores.member.Member;
import hello.cores.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    AppConfig appConfig = new AppConfig();
    MemberService service;
    OrderService orderService;


    @BeforeEach
    public void beferEach(){
        AppConfig appConfig = new AppConfig();
        service = appConfig.memberervice();
        orderService = appConfig.orderService();
    }


    @Test
    void createOrder(){
        Long memberId = 1L;
        Member test1 = new Member(memberId, "test1", Gradle.VIP);
        service.join(test1);

        Order order = orderService.createOrder(memberId,"item",10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}
