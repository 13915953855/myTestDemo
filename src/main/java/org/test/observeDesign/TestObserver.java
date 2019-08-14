package org.test.observeDesign;

/**
 * @Author: 徐森
 * @CreateDate: 2019/4/10
 * @Description:
 */
public class TestObserver {
    public static void main(String[] args) {
        User a = new User("用户A");
        User b = new User("用户B");
        User c = new User("用户C");
        WechatServer wechatServer = new WechatServer();
        wechatServer.registerObserver(a);
        wechatServer.registerObserver(b);
        wechatServer.registerObserver(c);
        wechatServer.setInfomation("hello everyone!");
    }
}
