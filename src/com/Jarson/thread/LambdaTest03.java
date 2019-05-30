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

public class LambdaTest03 {


    public static void main(String[] args) {
              Love love = (int i,int j)->{
            System.out.println("I love lambda");
        };
              love = (int i,int j)-> System.out.println("I love lambda2");
        //有参数时的简化
        love = (i,j)->{
            System.out.println("I love lambda3");
            System.out.println("I love lambda3");
        };

        love = (i,j)-> System.out.println("I love lambda3");




    }
}


interface Love{
    void iLove(int i,int j);
}
class Me implements Love{
    @Override
    public void iLove(int i,int j) {
        System.out.println("I love lambda");
    }
}

