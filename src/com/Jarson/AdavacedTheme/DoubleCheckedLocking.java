package com.Jarson.AdavacedTheme;

/**
 * @author Jarson
 * @create 2019-05-29 18:11
 */
/*
    DCL单例模式：在懒汉式的基础上加入了线程同步与volatile， 在多线程的坏境下，对外存在一个对象
        懒汉式：对象一开始制作声明，而等到有需要时调用。
     套路：
         1.构造器私有化--避免外部new构造器
         2.私有静态变量--存储对象的地址
         3.公共的静态方法
 */
public class DoubleCheckedLocking {
    //私有静态变量
    private static volatile DoubleCheckedLocking doubleCheckedLock;
            //volatile 使得该属性数据可以及时同步。
    //构造器私有化

    private DoubleCheckedLocking() {

    }
    //公共的静态方法
    public static DoubleCheckedLocking getDoubleCheckedLock(long time){
        synchronized (DoubleCheckedLocking.class) {       //加入同步块 注：当中为class模子的原因：因为该类当中的属性是静态的，而静态变量是从属于类的，所以需要class模子。
            if (null == doubleCheckedLock) {        //外部调用该方法时，如果该对象为空，则new一个对象
                try {
                    Thread.sleep(time); //模拟网络延时
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                doubleCheckedLock = new DoubleCheckedLocking();
            }
        }
        return doubleCheckedLock;
    }

    public static void main(String[] args){
            //模拟网络延时后，对象的地址不同了，原因：
                                                //a线程进入getDoubleCheckedLock（）后，发现对象为空，进入等待，在此同时，main线程也进入，也发现对象为空，
                                                //进入等待，两者都取得了对象，所以输出的地址会不同。
        Thread a = new Thread(()->{
            System.out.println(getDoubleCheckedLock(1000));
        });
        a.start();

        System.out.println(getDoubleCheckedLock(1500));
    }
}
