package com.gwc.proxy.service.factory;

import com.gwc.proxy.service.Impl.ServiceImpl;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyFactory implements MethodInterceptor {
    private ServiceImpl s;

    public ProxyFactory() {
        s = new ServiceImpl();
    }

    public Object create(Class clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("前");
        Object result = method.invoke(s, objects);
        System.out.println("后");
        return result;
    }
}
