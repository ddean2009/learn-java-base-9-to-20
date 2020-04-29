package com.flydean.copy;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wayne
 * @version CustUser,  2020/4/29 2:54 下午
 */
@Data
@NoArgsConstructor
public class CustUser implements Cloneable{
    private String firstName;
    private String lastName;
    private Address address;
    private String[] cars;

    @Override
    public Object clone() throws CloneNotSupportedException{
            return super.clone();
    }
}
