package com.Jarson.AdavacedTheme;

/**
 * @author Jarson
 * @create 2019-05-29 20:05
 */
/*
    ThreadLocal：指的是每个线程有着自身的存储空间，互不干涉。
     常用方法： set/get/initialValue
     声明时需要private static
 */
public class ThreadLocalTest02 {
    private static  ThreadLocal<Integer> local = new InheritableThreadLocal<>();//该子类会使得子线程拥有（copy）父线程的值，而在子线程中set该值不会影响到其它线程
public static void main(String[] args){
              //  local.set(233);//因为该方法在main线程中，所以导致的结果线程0没变化
                local.set(666);
        System.out.println(Thread.currentThread().getName()+"获得"+local.get());

                //线程0
                new Thread(new MyThread()).start();
}
    static class MyThread implements Runnable{
    //注：加入构造器后，在mian方法调用时，由于当中的new MyThread()从属于main线程的，到start（）后才属于线程0
        public MyThread() {
            System.out.println(Thread.currentThread().getName()+"-->"+local.get());
        }

        @Override
        public void run() { //这就从属于其它的线程

            //System.out.println(Thread.currentThread().getName()+"获得"+local.get());
            local.set(0);
            System.out.println(Thread.currentThread().getName()+"获得"+local.get());
        }
    }
}
