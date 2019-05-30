package com.Jarson.thread;

/**
 * @author Jarson
 * @create 2019-05-25 16:06
 */
/*
     Lambda表达式
     JDK1.8新特性，用于简化线程（简单，一次）的表达式
     接口只能有一个方法才能使用lambda
 */

public class LambdaTest01 {
    //静态内部类
        static class Test1 implements  Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                System.out.println("Coding");
            }

        }

    public static void main(String[] args){
            //局部内部类
        class Test2 implements  Runnable {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("Coding");
                }

            }
        }
//继续简化（只有线程体）lambda表达式
        new Thread(()->{
            //线程体
            for (int i = 0; i < 20; i++) {
                System.out.println("Coding");
            }
        }
        ).start();
    }
//        //放在方法体中的简化 匿名内部类
//        new Thread(new Runnable(){
//            @Override
//            public void run() {
//
//            }
//        }).start();


    }
}
