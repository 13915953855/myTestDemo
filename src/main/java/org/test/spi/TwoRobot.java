package org.test.spi;

public class TwoRobot implements Robot {
    @Override
    public void sayHello(String name) {
        System.out.println("TwoRobot say: hello,"+name);
    }
}
