package org.test.datalimit;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @Author: 徐森
 * @CreateDate: 2019/8/1
 * @Description:数据校验字段的注解
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Component
public @interface KeyType {
    String type() default "";
}
