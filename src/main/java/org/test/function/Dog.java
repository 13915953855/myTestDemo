package org.test.function;

/**
 * @Author: 徐森
 * @CreateDate: 2019/4/26
 * @Description:
 */
@Extension(code = "cat")
public class Dog implements Animal {
    @Override
    public String eat() {
        return "dog eat meat.";
    }
}
