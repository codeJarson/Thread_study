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

public class LambdaTest02 {


    public static void main(String[] args) {
        //run方法中只有一条语句的时候
        new Thread(()-> System.out.println("最简化lambda表达式")).start();

        new Thread(()-> {
            for (int i = 0; i <5 ; i++) {
                System.out.println("多行语句的lambda表达式");
            }
        }).start();
    }
}
