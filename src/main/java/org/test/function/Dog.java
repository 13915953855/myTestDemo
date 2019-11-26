package org.test.function;

/**
 * @Author: 徐森
 * @CreateDate: 2019/4/26
 * @Description:
 */
@Extension(code = "dog")
public class Dog implements Animal {
    @Override
    public String eat() {
        return "dog eat meat.";
    }
}
