package org.test;

import algurate.Hanoi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;

public class Test {
    public static void main(String[] args) throws Exception {
//        URL httpUrl = new URL("http://www.baidu.com");
//        BufferedReader in = new BufferedReader(new InputStreamReader(httpUrl.openStream(), "UTF-8"));
//        String line = null;
//        String content = "";
//        while ((line = in.readLine()) != null) {
//            content += line;
//        }
//        in.close();
//        System.out.println(content);
//        String className = "algurate.Hanoi";
//        try {
//            Class instance = Class.forName(className);
//            Object object = instance.newInstance();
//            Method method = instance.getDeclaredMethod("hanoi", int.class, char.class, char.class, char.class);
//            method.invoke(object, 2, 'A', 'B', 'C');
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
        //System.out.println(test());
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
    private static int test(){
        int a = 1;
        try{
            System.out.println(a);
            return ++a;
        }finally {
            ++a;
            System.out.println(a);
        }
    }
}
