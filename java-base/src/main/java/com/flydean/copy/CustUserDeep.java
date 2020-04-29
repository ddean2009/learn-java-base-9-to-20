package com.flydean.copy;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;

/**
 * @author wayne
 * @version CustUserDeep,  2020/4/29 2:54 下午
 */
@Data
@NoArgsConstructor
public class CustUserDeep implements Cloneable{
    private String firstName;
    private String lastName;
    private Address address;
    private String[] cars;

    //不是很好的使用方式
    @Override
    public Object clone() throws CloneNotSupportedException{
        CustUserDeep custUserDeep=(CustUserDeep)super.clone();
        custUserDeep.address=(Address)address.clone();
        custUserDeep.cars=cars.clone();
            return custUserDeep;
    }

    //很好的方式
    CustUserDeep(CustUserDeep custUserDeep){
    this.firstName=custUserDeep.firstName;
    this.lastName=custUserDeep.lastName;
//    this.cars= Arrays.copyOf(custUserDeep.getCars(),custUserDeep.getCars().length);
        this.cars=custUserDeep.getCars().clone();
    this.address=new Address(custUserDeep.getAddress());

    }


}
