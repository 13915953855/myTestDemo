package springboot.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.test.observeDesign.User;

/**
 * @Author: 徐森
 * @CreateDate: 2019/8/14
 * @Description:
 */
@Configuration
public class ConfigTest {
    @Bean(name="user")
    public Person user(ConstructClass e){
        Person user = new Person();
        user.setName("xusen");
        e.setName("admin");
        return user;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();

        ac.register(ConstructClass.class);
        ac.register(ConfigTest.class);
        ac.refresh();
        Person user = (Person) ac.getBean("user");
        System.out.println(user.getName());
    }
}
