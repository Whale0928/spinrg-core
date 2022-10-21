package hello.cores.Autowired;


import hello.cores.AutoAppConfig;
import hello.cores.discount.DiscountPolicy;
import hello.cores.member.Gradle;
import hello.cores.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class AllBeanTest {

    @Test
    void findAllBean(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class,DiscountService.class);

        DiscountService discountService = ac.getBean(DiscountService.class);
        Member userA = new Member(1L, "userA", Gradle.VIP);
        int discountPolicy = discountService.discount(userA,10000,"fixDiscountPolicy");
        //첫 글자를 대문자로 해서 빈이 불려오지 않았다. ㅠㅠ

        assertThat(discountService).isInstanceOf(DiscountService.class);
        assertThat(discountPolicy).isEqualTo(1000);

        int ratediscountPolicy = discountService.discount(userA,20000,"rateDiscountPolicy");
        assertThat(ratediscountPolicy).isEqualTo(2000);
    }


    static class DiscountService{
        private final Map<String,DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policyList;

        @Autowired
        public DiscountService(Map<String, DiscountPolicy> policMap, List<DiscountPolicy> policyList) {
            this.policyMap = policMap;
            this.policyList = policyList;
            System.out.println("policMap = " + policMap);
            System.out.println("policyList = " + policyList);
        }

        public int discount(Member member, int price, String discountCode) {
            DiscountPolicy discountPolicy = policyMap.get(discountCode);
            return discountPolicy.discount(member,price);
        }
    }
}
