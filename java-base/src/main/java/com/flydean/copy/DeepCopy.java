package com.flydean.copy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author wayne
 * @version DeepCopy,  2020/4/29 2:51 下午
 */
@Slf4j
public class DeepCopy {

    @Test
    public void testDeepCopy() throws CloneNotSupportedException {
        Address address= new Address();
        address.setName("北京天安门");
        CustUserDeep custUser = new CustUserDeep();
        custUser.setAddress(address);
        custUser.setLastName("李");
        custUser.setFirstName("雷");
        String[] cars = new String[]{"别克","路虎"};
        custUser.setCars(cars);

        CustUserDeep custUserCopy=(CustUserDeep) custUser.clone();
        custUserCopy.setFirstName("梅梅");
        custUserCopy.setLastName("韩");
        custUserCopy.getAddress().setName("北京颐和园");
        custUserCopy.getCars()[0]="奥迪";

        log.info("{}",custUser);
        log.info("{}",custUserCopy);
    }
}
