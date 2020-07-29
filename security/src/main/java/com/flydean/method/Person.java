package com.flydean.method;

/**
 * @author wayne
 * @version People,  2020/7/27
 */
public class Person implements Cloneable{

    public void printValue(){
        System.out.println("this is person!");
    }

    public Person(){
        printValue();
    }

    public Object clone() throws CloneNotSupportedException {
        Person person= (Person)super.clone();
        person.printValue();
        return person;
    }
}
