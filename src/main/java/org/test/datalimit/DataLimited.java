package org.test.datalimit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: 徐森
 * @CreateDate: 2019/7/31
 * @Description:数据校验注解
 * paramKey：请求头中参数对应的key
 * keyType：数据校验的字段
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataLimited {
    String paramKey()  default "";
    String keyType() default "";
}
