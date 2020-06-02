package org.test.spi;

public class OneRobot implements Robot {
    @Override
    public void sayHello(String name) {
        System.out.println("OneRobot say: hello,"+name);
    }
}
