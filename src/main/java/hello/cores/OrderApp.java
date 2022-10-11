package hello.cores;


import hello.cores.member.Gradle;
import hello.cores.member.Member;
import hello.cores.member.MemberService;
import hello.cores.order.Order;
import hello.cores.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext ac =new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService",MemberService.class);
        OrderService orderService = ac.getBean("orderService",OrderService.class);


        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Gradle.VIP);

        memberService.join(member);

        Order order = orderService.createOrder(memberId, "상품", 15000);

        order.setItemPrice(order.calculatePrice());

        System.out.println(order);
    }

}
