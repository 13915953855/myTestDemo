package org.test.digester;

import lombok.Data;

/**
 * @Author: 徐森
 * @CreateDate: 2019/11/26
 * @Description:
 */
@Data
public class Grade {
    private String name;
    private Class[] classes = new Class[0];
    private Object lock = new Object();

    public void addClass(Class c) {
        synchronized (lock) {
            Class results[] = new Class[classes.length + 1];
            System.arraycopy(classes,0,results,0,classes.length);
            results[classes.length] = c;
            classes = results;
        }
    }
}
