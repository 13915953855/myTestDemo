package org.test.observeDesign;

/**
 * @Author: 徐森
 * @CreateDate: 2019/4/10
 * @Description:
 */
public class User implements Observer {
    private String name;

    public User(String name) {
        this.name = name;
    }
    @Override
    public void update(String message) {
        System.out.println(name + " 收到推送消息： " + message);
    }
}
