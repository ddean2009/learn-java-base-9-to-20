package com.flydean.records;

/**
 * @author wayne
 * @version CustUserWithBody,  2020/4/27 1:47 下午
 */
public record CustUserWithBody(
        String firstName,
        String lastName,
        Address address,
        int age
) {
    public String fullName(){
        return firstName+ lastName;
    }

    public CustUserWithBody{
        if (age < 18) {
            throw new IllegalArgumentException( "男大当婚，女大当嫁，18岁未到，不许出嫁!");
        }
    }
}
