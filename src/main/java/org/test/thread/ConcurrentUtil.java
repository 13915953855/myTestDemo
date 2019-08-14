package org.test.thread;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Function;
/**
 * @Author: 徐森
 * @CreateDate: 2019/7/26
 * @Description:
 */
@Service
public class ConcurrentUtil {
    public static final int TASK_PER_THREAD_DEFAULT = 40;
    public static final int THREAD_SIZE_DEFAULT = 25;
    public static final int TIMEOUT_DEFAULT = 10;

    //并发执行，允许延迟执行 todo
    public static <R> List<R> multiProcessAsync(Collection<String> inputList, Function<String, R> function, Consumer<Exception> fallback) {
        return multiProcessAsync(inputList, function, fallback,
                1 + Math.min(inputList.size() / TASK_PER_THREAD_DEFAULT, THREAD_SIZE_DEFAULT), TIMEOUT_DEFAULT);
    }

    //并发执行，允许延迟执行
    public static <T, R> List<R> multiProcessAsync(Collection<T> inputList, Function<T, R> function, Consumer<Exception> fallback, int threadSize, int timeout) {
        List<Future<R>> futureList = new ArrayList<>();
        List<R> resultList = new ArrayList<>();
        //创建线程池, 每个线程最多分配20条设备，最多50个线程
        ExecutorService service = Executors.newFixedThreadPool(threadSize);
        //提交任务
        inputList.forEach(str -> futureList.add(service.submit(
                (() -> {
                    try {
                        return function.apply(str);
                    } catch (Exception e) {
                        fallback.accept(e);
                        return null;
                    }
                })
        )));
        try {
            //尝试关闭并等待所有线程处理完毕
            service.shutdown();
            if ((service.awaitTermination(inputList.size() * timeout / threadSize, TimeUnit.SECONDS))) {
            } else {
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        //解析处理任务
        futureList.forEach(future -> {
            try {
                R result = future.get(timeout, TimeUnit.SECONDS);
                if (null != result) {
                    resultList.add(result);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } catch (ExecutionException e) {
            } catch (TimeoutException e) {
            }
        });
        return resultList;
    }

    public static void main(String[] args) {
        List<String> ids = Arrays.asList("1","2","3");
        ConcurrentUtil.multiProcessAsync(ids,id -> {
            String name = id+"---"+id;
            System.out.println(name);
            return name;
        },null);
        System.out.println("end");
    }
}
