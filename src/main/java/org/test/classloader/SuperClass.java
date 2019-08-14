package org.test.classloader;

/**
 * @Author: 徐森
 * @CreateDate: 2019/5/23
 * @Description:
 */
public class SuperClass {
    static {
        System.out.println("SuperClass init.");
    }
    public static int value = 123;
    public static final String TEXT = "hello";
}
