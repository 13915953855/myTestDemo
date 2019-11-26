package org.test.interfaceTest;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author: 徐森
 * @CreateDate: 2019/1/16
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Filter f1 = new Filter();
        f1.setId(10);
        query(f1);
    }

    private static void query(Filter f1) {
        String sql = "";
        Class cls = f1.getClass();
        boolean is = cls.isAnnotationPresent(Table.class);
        if(!is){
            return;
        }
        Table t = (Table) cls.getAnnotation(Table.class);
        String tableName = t.value();
        sql += "select * from "+tableName +" where 1=1 ";

        Field[] arr = cls.getDeclaredFields();
        for (Field field : arr) {
            Column c = (Column) field.getAnnotation(Column.class);
            String columnName = c.value();
            String fieldName = field.getName();
            String getMethodName = "get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
            Object fieldValue = null;
            try {
                Method method = cls.getMethod(getMethodName);
                fieldValue = method.invoke(f1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            sql += " and "+columnName + "="+fieldValue;
        }
        System.out.println(sql);

        Method[] declaredMethods = cls.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            String methodName = declaredMethod.getName();
            if(methodName.startsWith("get")){
                try {
                    Method method = cls.getMethod(methodName);
                    System.out.println(methodName+"==="+method.invoke(f1));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        String canonicalName = cls.getCanonicalName();
        System.out.println(canonicalName);
        System.out.println(cls.getName());
        System.out.println(cls.getSimpleName());
        System.out.println(cls.getTypeName());
    }
}
