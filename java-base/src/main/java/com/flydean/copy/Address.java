package com.flydean.copy;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wayne
 * @version Address,  2020/4/29 2:55 下午
 */
@Data
@NoArgsConstructor
public class Address implements Cloneable{
    private String name;

    //不是好的方式
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();

    }

    //好的方式
    Address(Address address){
        this.name=address.name;
    }

}
