package springboot.config;

import org.springframework.stereotype.Component;

/**
 * @Author: 徐森
 * @CreateDate: 2019/8/14
 * @Description:
 */
@Component
public class ConstructClass {
    private String name;
    public ConstructClass(){
        System.out.println("first");
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}
