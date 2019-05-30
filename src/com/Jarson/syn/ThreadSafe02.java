package com.Jarson.syn;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jarson
 * @create 2019-05-26 20:43
 */
/*
    线程同步
       synchronized (object) 同步块
                作用：
                    使得当中object（任何对象）锁的对象更加明确，线程更安全

 */
public class ThreadSafe02 {

    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();
        for (int i = 0; i <1000; i++) { //循环创建线程
            //lambda表达式
            new Thread(()->{
                synchronized(list){
                    list.add(Thread.currentThread().getName());

                }
            }).start();//而start后的线程需要等待cpu取调度，所以需要时间
        }
        //加上sleep的原因：  为了等待全部1000个线程执行完，才输出大小
        Thread.sleep(2000);
        System.out.println(list.size());
    }
}
