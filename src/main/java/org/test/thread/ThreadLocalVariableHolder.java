package org.test.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalVariableHolder {
    private static final ThreadLocal<Integer> variableHolder = new ThreadLocal<>();

    public static int getValue() {
        return variableHolder.get();
    }

    public static void remove() {
        variableHolder.remove();
    }

    public static void increment() {
        variableHolder.set(variableHolder.get() + 1);
    }

    public static void main(String[] args) {
        variableHolder.set(1);
        increment();
        System.out.println("before remove:" + getValue());
        remove();
        System.out.println("after remove:" + getValue());

        /*ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 50; i++) {
                executor.execute(() -> {
                    try {
                        long threadId = Thread.currentThread().getId();
                        remove();
                        int before = getValue();
                        increment();
                        int after = getValue();
                        System.out.println("threadId: " + threadId + ", before: " + before + ", after: " + after);
                    }finally {
                        //remove();
                    }
                });
        }

        executor.shutdown();*/
    }
}