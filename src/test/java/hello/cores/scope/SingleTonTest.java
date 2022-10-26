package hello.cores.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SingleTonTest {

    @Test
    void singletonBeanTest(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);

        SingletonBean bean1 = ac.getBean(SingletonBean.class);
        SingletonBean bean2 = ac.getBean(SingletonBean.class);
        System.out.println("bean1 = " + bean1);
        System.out.println("bean2 = " + bean2);
        Assertions.assertThat(bean1).isSameAs(bean2);
        ac.close();;
    }

    @Scope("singleton")
    static class SingletonBean{
        @PostConstruct //객체 생성 전
        public void init(){
            System.out.println("SingletonBean.init");
        }
        @PreDestroy//객체 소멸 바로 직전
        public void detroy(){
            System.out.println("SingletonBean.detroy");
        }
    }
}
