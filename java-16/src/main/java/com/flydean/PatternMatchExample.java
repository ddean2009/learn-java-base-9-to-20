package com.flydean;

public class PatternMatchExample {

    public static void main(String[] args) {

        Object site = "www.flydean.com";

        //传统写法
        if(site instanceof String){
            String stringSite = (String)site;
            System.out.println(stringSite.length());
        }

        //JDK16写法
        if(site instanceof String stringSite){
            System.out.println(stringSite.length());
        }

        Integer integer= new Integer(100);

        Integer integer2= 100;


    }
}
