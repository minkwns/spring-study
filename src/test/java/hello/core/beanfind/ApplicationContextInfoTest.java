package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ApplicationContextInfoTest { // Junit5부터는 public 제외 가능

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("beanDefinitionName  = " + beanDefinitionName + " object = "+ bean);
            
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            //
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) { // 내가 애플리케이션을 만들어서 주입한 것을 뽑을 때 ROLE_APPLICATION / 우리가 만든 것만 출력할 수가 있음.
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("beanDefinitionName  = " + beanDefinitionName + " object = "+ bean);
            }

        }
    }
}
