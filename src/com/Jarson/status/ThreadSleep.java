package com.Jarson.status;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Jarson
 * @create 2019-05-25 22:01
 */
/*
    线程中的sleep（）可以使得线程休眠一会，产生延时
    通过该方法我们可以看到线程体中的错误
 */
public class ThreadSleep{

    public static void main(String[] args) throws InterruptedException {
        //倒计时操作
        Date endTime = new Date(System.currentTimeMillis()+1000*10);//十秒后
        long end = endTime.getTime();
        while(true){
            System.out.println(new SimpleDateFormat("mm:ss").format(endTime));
                Thread.sleep(1000);
                endTime = new Date(endTime.getTime()-1000);

                if(end-10000>endTime.getTime()){    //倒计时十秒后结束循环
                    break;
                }
        }
    }

}
