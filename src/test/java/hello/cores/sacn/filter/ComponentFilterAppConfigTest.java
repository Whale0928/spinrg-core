package hello.cores.sacn.filter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.context.annotation.ComponentScan.Filter;

public class ComponentFilterAppConfigTest {

    @Test
    void filter(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(filterAppConfig.class);

        BeanA beanA = ac.getBean(BeanA.class);
        assertThat(beanA).isNotNull();
        Assertions.assertThrows(NoSuchBeanDefinitionException.class,()->ac.getBean("BeanB",BeanB.class));
    }

    @Configuration
    @ComponentScan(
            includeFilters = @Filter(type= FilterType.ANNOTATION,classes =MyIncludeComponent.class),
            excludeFilters = @Filter(type= FilterType.ANNOTATION,classes =MyExcludeComponent.class))
    static class filterAppConfig{}

}