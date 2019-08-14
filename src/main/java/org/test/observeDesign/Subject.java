package org.test.observeDesign;

/**
 * @Author: 徐森
 * @CreateDate: 2019/4/10
 * @Description:抽象被观察者
 */
public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver();
}
