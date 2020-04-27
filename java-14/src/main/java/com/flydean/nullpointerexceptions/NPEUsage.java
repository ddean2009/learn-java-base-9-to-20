package com.flydean.nullpointerexceptions;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wayne
 * @version NPEUsage,  2020/4/27 10:13 上午
 */
@Slf4j
public class NPEUsage {

    public static void main(String[] args) {
        Address address=new Address();
        CustUser custUser=new CustUser();
        custUser.setAddress(address);
        log.info(custUser.getAddress().getAddressName().toLowerCase());
    }
}
