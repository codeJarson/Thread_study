package com.Jarson.status;

/**
 * @author Jarson
 * @create 2019-05-26 13:59
 */
/*
    守护线程： 为用户线程所服务，jvm不需等待该线程执行完毕后才关闭。
    用户线程：jvm需要等待用户线程执行完毕后才能关闭。
 */
public class DaemonThread {
    public static void main(String[] args){
        God god = new God();
        C c = new C();
        Thread godThread = new Thread(god);
        Thread cThread = new Thread(c);
            //将godThread设置为守护线程
            godThread.setDaemon(true);

        godThread.start();
        cThread.start();

    }
}
class C implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <666; i++) {
            System.out.println("我是主C哥");

        }
    }


}
class God implements Runnable{
    @Override
    public void run() {
        while(true){

            System.out.println("我是神思者，爸爸奶你");
        }
    }
}