package org.test.spi;

import java.util.ServiceLoader;

public class RobotTest {
    public static void main(String[] args) {
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        System.out.println("JAVA SPI...");
        for (Robot robot : serviceLoader) {
            robot.sayHello("world");
        }
    }
}
