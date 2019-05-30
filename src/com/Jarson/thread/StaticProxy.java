package com.Jarson.thread;

/**
 * @author Jarson
 * @create 2019-05-25 15:34
 */


/*
    静态代理设计模式：
       真实角色
       代理角色
       两者实现共同的接口
 */
public class StaticProxy {
        public static void main(String[] args){
            new Hotel(new You()).prepareFeast();
    //相当于new  Thread(线程对象).start();
        }
}
//真实角色
   class You implements  PrepareFeast{
    public void prepareFeast(){
        System.out.println("Jarson");
    }

}
//代理角色
class Hotel implements  PrepareFeast{
    private PrepareFeast  person;

    public Hotel(PrepareFeast person) {
        this.person = person;
    }



    public void prepareFeast(){
        ready();
        System.out.println(this.person+"摆酒宴");
        after();
    }
    public void ready(){
        System.out.println("做好准备");
    }
    public void after(){
        System.out.println("收拾");
    }
}
//共同的接口
interface PrepareFeast{
    public void prepareFeast();
}


