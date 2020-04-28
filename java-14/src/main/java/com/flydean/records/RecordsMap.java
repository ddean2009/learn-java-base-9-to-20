package com.flydean.records;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wayne
 * @version RecordsMap,  2020/4/27 11:22 上午
 */
@Slf4j
public class RecordsMap {

    public static void main(String[] args) {
        Address address= new Address("天安门","北京");
        CustUser custUser = new CustUser("雷","李",address,18);
        log.info("{}",custUser);
    }
}
