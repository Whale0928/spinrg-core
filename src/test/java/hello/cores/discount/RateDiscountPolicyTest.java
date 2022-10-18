package hello.cores.discount;

import hello.cores.member.Gradle;
import hello.cores.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;

import static org.assertj.core.api.Assertions.assertThat;

@Component
class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_o(){
        //given
        Member vip = new Member(1L, "VIP", Gradle.VIP);
        //when
        int discount = discountPolicy.dscount(vip, 10000);
        //then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIp가 아니면 할인이 적용되지 않는다")
    void Basic(){
        //given
        Member basic = new Member(1L, "VIP", Gradle.BASIC);
        //when
        int discount = discountPolicy.dscount(basic, 10000);
        //then
        assertThat(discount).isEqualTo(0);
    }

}