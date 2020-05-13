package com.flydean.serialization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author wayne
 * @version CustUserV3,  2020/5/11 5:02 下午
 */
@Slf4j
@Data
@AllArgsConstructor
public class CustUserV3 implements java.io.Serializable{

    private String name;
    private String address;

    private Object writeReplace()
            throws java.io.ObjectStreamException
    {
        log.info("writeReplace {}",this);
        return new CustUserV3Proxy(this);
    }
}
