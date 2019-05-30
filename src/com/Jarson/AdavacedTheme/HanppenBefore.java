package com.Jarson.AdavacedTheme;

/**
 * @author Jarson
 * @create 2019-05-29 16:19
 */
/*
    指令重排：
            分析： 由于主存的运行速度没有CPU的运行速度快，所以jvm底层对它进行了处理，对代码在不改变结果的情况下出现指令重排。
                也就是将后面的代码执行提前。
 */
public class HanppenBefore {
    public static int a ;
    public static boolean flag ;
    public static void main(String[] args) throws InterruptedException {
        a = 0;
        flag = false;
        for (int i = 0; i < 10; i++) {
            //修改
            Thread t1= new Thread(()->{
                a = 1;
                flag = true;
            });
            Thread t2 = new Thread(()->{
                if(flag){
                    a *= 1;
                }
                if(a==0){
                    System.out.println("HappenBefore"+a);
                }
            });

            t1.start();
            t2.start();

            t1.join();
            t2.join();
        }

    }
}
