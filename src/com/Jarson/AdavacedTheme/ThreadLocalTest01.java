package com.Jarson.AdavacedTheme;

/**
 * @author Jarson
 * @create 2019-05-29 20:05
 */
/*
    ThreadLocal：指的是每个线程有着自身的存储空间，互不干涉。
     常用方法： set/get/initialValue
     声明时需要private，static
 */
public class ThreadLocalTest01 {
    private static  ThreadLocal<Integer> local = ThreadLocal.withInitial(()->1);//为local创建一个局部变量
public static void main(String[] args){
              //  local.set(233);//因为该方法在main线程中，所以导致的结果线程0没变化
        System.out.println(Thread.currentThread().getName()+"获得"+local.get());
            local.set(0);
    System.out.println(Thread.currentThread().getName()+"剩余"+local.get());
                //线程0
                new Thread(new MyThread()).start();
}
    static class MyThread implements Runnable{
        @Override
        public void run() { //这就从属于其它的线程

            System.out.println(Thread.currentThread().getName()+"获得"+local.get());
            local.set(0);
            System.out.println(Thread.currentThread().getName()+"剩余"+local.get());
        }
    }
}
