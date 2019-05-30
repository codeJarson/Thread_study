package com.Jarson.thread;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author Jarson
 * @create 2019-05-25 11:37
 */
/*
    该类为图片下载
 */
public class DownLoader {
/*

       利用IO工具集使用copuURLToFile方法下载图片。
 */

        public  void download(String url, String destName){
                try {
                        FileUtils.copyURLToFile(new URL(url),new File(destName));
                } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("URL is error");
                }catch(Exception e){
                        e.printStackTrace();
                }
        }
}
