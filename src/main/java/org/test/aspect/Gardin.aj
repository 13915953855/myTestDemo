package org.test.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @Author: 徐森
 * @CreateDate: 2019/12/27 
 * @Description:
 * */
@Aspect
public class Gardin {
    @Pointcut("execution(* org.test.aspect.Monkey(..))")
    public void findMonkey(){}

    @Before("findMonkey()")
    public void a(){
        System.out.println("【守护者】发现猴子正在进入果园...");
    }
    @After("findMonkey() && args(name)")
    public void b(String name){
        System.out.println("【守护者】抓住了猴子,守护者审问出了猴子的名字叫“"+name+"”...");
    }
}
