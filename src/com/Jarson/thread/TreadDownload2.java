package com.Jarson.thread;

/**
 * @author Jarson
 * @create 2019-05-25 11:49
 */
/*
    创建多线程的方式二：
        1.实现Runnable接口+重写run方法
        2.创建实现类对象+代理类对象（Tread）+start（）
        利端：方便我们共享资源，避免了继承的局限性
    利用多线程下载网页上的图片
 */

public class TreadDownload2 implements Runnable{
    //根据面向对象的知识
    private String URL;
    private String destName;


    public TreadDownload2(String URL, String destName) {
        this.URL = URL;
        this.destName = destName;
    }

    @Override
    public void run() {
        DownLoader downLoader = new DownLoader();
        downLoader.download(URL,destName);
        System.out.println(destName);
    }
    public static void main(String[] args){
        //创建实现类对象
        TreadDownload2 td1 = new TreadDownload2("http://p1.pstatp.com/large/403c00037462ae2eee13","spl.jpg");
        TreadDownload2 td2 = new TreadDownload2("https://www.baidu.com/img/bd_logo1.png?qua=high","baidu.png");
        TreadDownload2 td3 = new TreadDownload2("http://img.lanrentuku.com/img/allimg/1709/15067611397111.jpg","persons.jpg");

        /*
        这三个线程是用时执行的，没有先后顺序
         */
        //创建代理类对象 调用start方法
        new Thread(td1).start();
        new Thread(td2).start();
        new Thread(td3).start();

    }
}
