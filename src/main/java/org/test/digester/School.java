package org.test.digester;

import lombok.Data;

/**
 * @Author: 徐森
 * @CreateDate: 2019/11/26
 * @Description:
 */
@Data
public class School {
    private String name;
    private Grade[] grades = new Grade[0];
    private Object lock = new Object();

    public void addGrade(Grade g){
        synchronized (lock){
            Grade results[] = new Grade[grades.length+1];
            System.arraycopy(grades,0,results,0,grades.length);
            results[grades.length] = g;
            grades = results;
        }
    }
}
