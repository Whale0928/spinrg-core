package hello.cores.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class PrototypeTest {

    @Test
    void prototypeTest(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);

        PrototypeBean bean1 = ac.getBean(PrototypeBean.class);
        System.out.println("1");
        PrototypeBean bean2 = ac.getBean(PrototypeBean.class);
        System.out.println("2");
        System.out.println("bean1 = " + bean1);
        System.out.println("bean2 = " + bean2);
        Assertions.assertThat(bean1).isNotSameAs(bean2);
        ac.close();
    }

    @Scope("prototype")
    static class PrototypeBean{
        @PostConstruct //객체 생성 전
        public void init(){
            System.out.println("SingletonBean.init");
        }
        @PreDestroy//객체 소멸 바로 직전
        public void destroy(){
            System.out.println("SingletonBean.detroy");
        }
    }
}
