package com.quicktutorialz.nio.services;

public class MyServiceImpl implements MyService{

    /* singleton implementation */
    private static MyService instance;
    private MyServiceImpl(){}
    public static MyService getIntance(){
        return (instance==null) ? new MyServiceImpl() : instance;
    }


    @Override
    public void doSomethingVoid(String param) {
        System.out.println("Inside MyServiceImpl: " + param);
    }

    @Override
    public String doSomethingString(String param) {
        return param.toUpperCase();
    }
}
