package org.test.jmockit;

import java.util.Locale;

/**
 * @Author: 徐森
 * @CreateDate: 2019/4/10
 * @Description:
 */
public class HelloJMockit {
    public String sayHello() {
        Locale locale = Locale.getDefault();
        if(locale.equals(Locale.CHINA)){
            return "你好，JMockit!";
        }else{
            return "Hello,JMockit!";
        }
    }
}
