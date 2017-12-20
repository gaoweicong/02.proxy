package com.gwc.proxy.service;

import com.gwc.proxy.service.Impl.ServiceImpl;
import com.gwc.proxy.service.factory.ProxyFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        final Service impl = (ServiceImpl) new ProxyFactory().create(ServiceImpl.class);
        Service si = new ServiceImpl();
        Service service= (Service)Proxy.newProxyInstance(si.getClass().getClassLoader(), si.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("前");
                Object result = method.invoke(si, args);
                System.out.println("后");
            }
        });
        service.sayHi();
        impl.sayHello();
        impl.sayHi();
    }
}
