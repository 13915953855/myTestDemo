package org.test.ShutdownHook;

import org.apache.catalina.startup.Catalina;
import org.apache.juli.ClassLoaderLogManager;
import org.apache.tomcat.util.ExceptionUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogManager;

import static java.lang.Thread.sleep;

/**
 * @Author: 徐森
 * @CreateDate: 2019/11/27
 * @Description:
 */
public class MyRunService {

    private MyShutdownHook shutdownHook = null;
    private volatile static boolean a = true;

    static class OOMObject {
    }

    public void start() throws Exception {
        System.out.println("开始运行!a="+a);
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true) {
            list.add(new OOMObject());
        }
    }
    public void start2() {
        System.out.println("开始运行钩子");
        if (shutdownHook == null) {
            shutdownHook = new MyRunService.MyShutdownHook();
        }
        Runtime.getRuntime().addShutdownHook(shutdownHook);
    }
    public void stop(){
        System.out.println("停止运行，设置a为false");
        a = false;
        System.out.println("停止运行！a="+a);
    }
    public static void main(String[] args) throws Exception {
        MyRunService myRunService = new MyRunService();
        Method method = myRunService.getClass().getMethod("start", (Class [] )null);
        Method method2 = myRunService.getClass().getMethod("start2", (Class [] )null);

        method2.invoke(myRunService, (Object [])null);
        method.invoke(myRunService, (Object [])null);
    }

    protected class MyShutdownHook extends Thread {

        @Override
        public void run() {
            MyRunService.this.stop();
        }
    }
}
