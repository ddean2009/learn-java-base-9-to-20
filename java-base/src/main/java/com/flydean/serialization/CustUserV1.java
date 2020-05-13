package com.flydean.serialization;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author wayne
 * @version CustUser,  2020/5/11 5:02 下午
 */
@Data
@AllArgsConstructor
public class CustUserV1 implements java.io.Serializable{

    private static final long serialVersionUID = -178469307574906636L;

    private String name;
    private String address;
    private int age;

}
