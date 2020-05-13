package com.flydean.serialization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author wayne
 * @version CustUser,  2020/5/11 5:02 下午
 */
@Slf4j
@Data
public class CustUserV3Proxy implements java.io.Serializable{

    private String data;

    public CustUserV3Proxy(CustUserV3 custUserV3){
        data =custUserV3.getName()+ "," + custUserV3.getAddress();
    }

    private Object readResolve()
            throws java.io.ObjectStreamException
    {
        String[] pieces = data.split(",");
        CustUserV3 result = new CustUserV3(pieces[0], pieces[1]);
        log.info("readResolve {}",result);
        return result;
    }
}
