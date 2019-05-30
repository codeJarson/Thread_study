package com.Jarson.thread;

/**
 * @author Jarson
 * @create 2019-05-25 11:49
 */
/*
    利用多线程下载网页上的图片
 */

public class TreadDownload extends Thread{
    //根据面向对象的知识
    private String URL;
    private String destName;


    public TreadDownload(String URL,String destName) {
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
        //创建子类对象
        TreadDownload td1 = new TreadDownload("http://p1.pstatp.com/large/403c00037462ae2eee13","spl.jpg");
        TreadDownload td2 = new TreadDownload("https://www.baidu.com/img/bd_logo1.png?qua=high","baidu.png");
        TreadDownload td3 = new TreadDownload("http://img.lanrentuku.com/img/allimg/1709/15067611397111.jpg","persons.jpg");

        /*
        这三个线程是用时执行的，没有先后顺序
         */
        //调用start方法
        td1.start();
        td2.start();
        td3.start();

    }
}
