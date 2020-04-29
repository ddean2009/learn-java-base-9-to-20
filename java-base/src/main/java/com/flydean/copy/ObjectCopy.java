package com.flydean.copy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author wayne
 * @version ObjectCopy,  2020/4/29 3:55 下午
 */
@Slf4j
public class ObjectCopy {

    @Test
    public void testObjectCopy(){
        Address address= new Address();
        address.setName("北京天安门");
        CustUser custUser = new CustUser();
        custUser.setAddress(address);
        custUser.setLastName("李");
        custUser.setFirstName("雷");
        String[] cars = new String[]{"别克","路虎"};
        custUser.setCars(cars);

        CustUser custUserCopy=custUser;
        custUserCopy.setFirstName("梅梅");
        custUserCopy.setLastName("韩");
        custUserCopy.getAddress().setName("北京颐和园");
        custUserCopy.getCars()[0]="奥迪";

        log.info("{}",custUser);
        log.info("{}",custUserCopy);
    }
}
