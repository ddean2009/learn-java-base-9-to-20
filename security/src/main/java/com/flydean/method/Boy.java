package com.flydean.method;

import java.util.HashMap;

/**
 * @author wayne
 * @version Boy,  2020/7/27
 */
public class Boy extends Person{

    public void printValue(){
        System.out.println("this is Boy!");
    }

    public Boy(){
        super();
    }



    public Object clone() throws CloneNotSupportedException {
        Boy clone = (Boy) super.clone();
        clone.printValue();
        return clone;
    }

    public static void main(String[] args) {
        Person persion= new Person();
        Boy boy= new Boy();
    }
}
