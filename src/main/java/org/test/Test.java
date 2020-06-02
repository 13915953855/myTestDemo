package org.test;

import algurate.Hanoi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;
import java.util.concurrent.*;

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
        //System.out.println(Runtime.getRuntime().availableProcessors());

        //test();

//        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(100);
//        ThreadFactory factory = r -> new Thread(r, "test-thread-pool");
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5,
//                0L, TimeUnit.SECONDS, queue, factory);
//        while (true) {
//            executor.submit(() -> {
//                try {
//                    System.out.println(queue.size());
//                    Thread.sleep(10000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });
//        }


    }
    private static void s(String a){
        a = "test";
    }
    private static void m(Map<String,String> a){
        a.put("name","test");
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
    static final int MAXIMUM_CAPACITY = 1 << 30;

    static final int tableSizeFor(int cap) {
        int n = cap -1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n +1;
    }
}
