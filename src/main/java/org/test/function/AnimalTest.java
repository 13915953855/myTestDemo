package org.test.function;

import org.junit.Test;
import org.test.Demo;

import java.util.LinkedHashMap;

/**
 * @Author: 徐森
 * @CreateDate: 2019/4/26
 * @Description:
 */
public class AnimalTest {
    public static void take(TDemo<? extends Animal> a){
        a.print();
    }

    public static void main(String[] args) {
        TDemo<Dog> dog = new TDemo<>(new Dog());
        take(dog);
        TDemo<Cat> cat = new TDemo<>(new Cat());
        take(cat);
    }
}
