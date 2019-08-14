package org.test.function;

/**
 * @Author: 徐森
 * @CreateDate: 2019/4/26
 * @Description:
 */
public class TDemo<T> {
    private T ob;
    public T getOb() {
        return ob;
    }
    public void setOb(T ob) {
        this.ob =ob;
    }
    public TDemo(T ob) {
        super();
        this.ob =ob;
    }
    public void print(){
        System.out.println("T的类型是："+ob.getClass().getName());
    }
}
