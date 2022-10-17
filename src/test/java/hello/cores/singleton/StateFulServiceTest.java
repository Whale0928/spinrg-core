package hello.cores.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class StateFulServiceTest {

    @Test
    void StateFulServieSingleton(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StateFulService service1 = ac.getBean(StateFulService.class);
        StateFulService service2 = ac.getBean(StateFulService.class);

        //A 사용자가 10000원 주문
        int a = service1.order("A",10000);
        //B 사용자가 20000원 주문
        int b = service2.order("B",20000);

        //A가 주문금액 조회
        int price = service1.getPrice();

        /**
         * name = Aprice : 10000
         * name = Bprice : 20000
         * price = 20000
         */
        assertThat(a).isEqualTo(10000);
        assertThat(b).isEqualTo(20000);
    }
    static class TestConfig{
        @Bean
        public StateFulService statefulService(){
            return new StateFulService();
        }
    }
}