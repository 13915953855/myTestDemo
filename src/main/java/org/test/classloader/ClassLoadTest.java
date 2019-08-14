package org.test.classloader;

/**
 * @Author: 徐森
 * @CreateDate: 2019/5/21
 * @Description:
 */
public class ClassLoadTest {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());


        MyClassLoader loader = new MyClassLoader("D:/项目代码/workspace/test");
        Class<?> c = loader.loadClass("org.test.linshi.MD5Util");
        System.out.println(c.getClassLoader());
    }
}
