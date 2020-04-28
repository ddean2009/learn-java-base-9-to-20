package com.flydean.records;

/**
 * @author wayne
 * @version CustUser,  2020/4/27 11:06 上午
 */
public record CustUser(
        String firstName,
        String lastName,
        Address address,
        int age
) {}
