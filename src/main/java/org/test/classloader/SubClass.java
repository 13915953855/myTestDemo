package org.test.classloader;

/**
 * @Author: 徐森
 * @CreateDate: 2019/5/23
 * @Description:
 */
public class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init.");
    }
}
