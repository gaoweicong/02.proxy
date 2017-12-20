package com.gwc.proxy.service.Impl;

import com.gwc.proxy.service.Service;

public class ServiceImpl implements Service {
    public void sayHello() {
        System.out.println("执行力sayHello");
    }

    public String sayHi() {
        System.out.println("执行了sayHi");
        return "hi";
    }
}
