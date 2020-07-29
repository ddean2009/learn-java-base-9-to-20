package com.flydean.atomicity;

/**
 * @author wayne
 * @version ChainedMethod,  2020/7/29
 */
public class ChainedMethod {
    private int age=0;
    private String name="";
    private String adress="";

    public ChainedMethod setAdress(String adress) {
        this.adress = adress;
        return this;
    }

    public ChainedMethod setAge(int age) {
        this.age = age;
        return this;
    }

    public ChainedMethod setName(String name) {
        this.name = name;
        return this;
    }

    public static void main(String[] args) {
        ChainedMethod chainedMethod= new ChainedMethod();
        Thread t1 = new Thread(() -> chainedMethod.setAge(1).setAdress("www.flydean.com1").setName("name1"));
        t1.start();

        Thread t2 = new Thread(() -> chainedMethod.setAge(2).setAdress("www.flydean.com2").setName("name2"));
        t2.start();
    }
}
