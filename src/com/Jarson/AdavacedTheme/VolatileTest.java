package com.Jarson.AdavacedTheme;

/**
 * @author Jarson
 * @create 2019-05-29 17:36
 */
/*
    Volatile:用于确保数据的同步，可见性。
           我们的每一个线程中会有一个工作空间，而该空间与主内存打交道，如果线程很多或主内存很忙的不可开交（修改保存等操作）的时候，而数据就会出错。
           而我们加了volatile之后，可以使得数据立即同步，完善了可见性
 */
public class VolatileTest {
    private volatile static int num = 0;
    public static void main(String[] args){
        Thread tr1 = new Thread(()->{
           while(num==0){
               //死循环
           }

        });
        tr1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        num = 1;
    }
}
