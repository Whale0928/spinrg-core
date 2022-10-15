package hello.cores.beanFinder;

import hello.cores.discount.DiscountPolicy;
import hello.cores.discount.FixDiscountPolicy;
import hello.cores.discount.RateDiscountPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextExtendsFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
    private Object assertThat;

    @Configuration
    static class TestConfig {

        @Bean
        public DiscountPolicy rateDiscountPolicy() {
            return new RateDiscountPolicy();
        }

        @Bean
        public DiscountPolicy fixDiscountPolicy() {
            return new FixDiscountPolicy();
        }

    }


    @Test
    @DisplayName("부모타입으로 조회 시 자식이 둘 이상일 경우 중복 오류")
    void findBeanByParentTypeDuplicate() {
//        DiscountPolicy dp = ac.getBean(DiscountPolicy.class);

        assertThrows(NoUniqueBeanDefinitionException.class,()->ac.getBean(DiscountPolicy.class));

    }

    @Test
    @DisplayName("자식이 둘 이상일 경우 빈 이름을 지정")
    void findBeanByParentTypeName() {
        DiscountPolicy dp = ac.getBean("rateDiscountPolicy",DiscountPolicy.class);
        assertThat(dp).isInstanceOf(RateDiscountPolicy.class);
    }


}