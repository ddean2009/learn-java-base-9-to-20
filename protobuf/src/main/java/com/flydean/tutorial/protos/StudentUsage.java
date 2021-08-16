package com.flydean.tutorial.protos;

/**
 * @author wayne
 * @version StudentUsage,  2021/8/15
 */
public class StudentUsage {
    public static void main(String[] args) {
        Student xiaoming =
                Student.newBuilder()
                        .setId(1234)
                        .setName("小明")
                        .setEmail("flydean@163.com")
                        .addPhones(
                                Student.PhoneNumber.newBuilder()
                                        .setNumber("010-1234567")
                                        .setType(Student.PhoneType.HOME))
                        .build();

        System.out.println(xiaoming.isInitialized());

    }
}
