package com.sby.guava;

import org.springframework.stereotype.Component;

@Component
public class GuavaService {
    //模拟查询用户集合需要1秒钟
    public Long getUserList() throws InterruptedException {
        Thread.sleep(1000);
        return 1L;
    }

    //模拟查询订单集合需要2秒钟
    public Long getOrderList() throws InterruptedException {
        Thread.sleep(2000);
        return 2L;
    }

    //模拟查询信息集合需要5秒钟
    public Long getMessageList() throws InterruptedException {
        Thread.sleep(5000);
        return 5L;
    }

    //模拟查询地址集合需要7秒钟
    public Long getAddressList() throws InterruptedException{
        Thread.sleep(7000);
        try{
            throw new RuntimeException("throw error");
        }catch (Exception e){
            e.printStackTrace();
        }
        return 7L;
    }

}
