package hello.cores.beanFinder;

import hello.cores.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac
            = new AnnotationConfigApplicationContext(AppConfig.class);


    @Test
    @DisplayName("All Bean Sysout")
    void findAllBean(){
        String[] beans = ac.getBeanDefinitionNames();
        for (String beanDefinitonName : beans) {
            Object bean = ac.getBean(beanDefinitonName);
            System.out.println("\nName = " + beanDefinitonName+"\nbean="+bean);
        }
    }

    @Test
    @DisplayName("All Bean Sysout")
    void findApplicationBean(){
        String[] beans = ac.getBeanDefinitionNames();
        for (String beanDefinitonName : beans) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitonName);

            if(beanDefinition.getRole()==BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(beanDefinitonName);
                System.out.println("beanDefinition = " + beanDefinition);
            }
        }
    }
}
