package com.Jarson.syn;

import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Jarson
 * @create 2019-05-28 20:27
 */
public class TimerTask01 {
    public static void main(String[] args){
        //定义一个计时器,相当于闹钟的效果
        Timer timer = new Timer();
        TimerTask myTask = new MyTask();//需要计时启动的线程
           // timer.schedule(myTask,3000);    //每3秒，执行一次该线程
        GregorianCalendar calendar1 = new GregorianCalendar(2019,5,28,20,36,10);
        timer.schedule(myTask,calendar1.getTime()); //指定时间定时执行；
    }
}
class MyTask extends TimerTask{
    @Override
    public void run() {
        for (int  i= 0;  i< 10; i++) {
            System.out.println("任务"+i);
        }
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

}