package org.test.function;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @Author: 徐森
 * @CreateDate: 2019/4/26
 * @Description:
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Component
public @interface Extension {
    String code() default "";
}
