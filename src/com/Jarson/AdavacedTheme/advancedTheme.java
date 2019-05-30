package com.Jarson.AdavacedTheme;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Jarson
 * @create 2019-05-29 15:10
 */
/*
    高级主题中的Timer类与TimerTask抽象类

 */
public class advancedTheme {
    public static void main(String[] args){
        //定义一个计时器,相当于闹钟的效果
        Timer timer = new Timer();
        TimerTask myTask1 = new MyTask1();//需要计时启动的线程
        // timer.schedule(myTask,3000);    //每3秒，执行一次该线程开始的
        timer.schedule(myTask1,3000,1000);//3秒后执行线程，每隔1秒执行该线程
        //GregorianCalendar calendar1 = new GregorianCalendar(2019,4,29,15,14,30);//注：月份是从0
       // timer.schedule(myTask1,calendar1.getTime()); //指定时间定时执行；
    }
}
class MyTask1 extends TimerTask{
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
