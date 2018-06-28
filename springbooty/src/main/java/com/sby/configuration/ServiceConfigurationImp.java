package com.sby.configuration;

/**
 * Created by zheng on 2018/6/28.
 */
public class ServiceConfigurationImp implements ServiceConfiguration {

    @Override
    public void save(){
        System.out.println("==================================start==================================");
        System.out.println("..............................保存成功....................................");
        System.out.println("==================================end====================================");
    }
}
