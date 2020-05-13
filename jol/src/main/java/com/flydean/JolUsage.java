package com.flydean;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;
import org.openjdk.jol.vm.VM;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author wayne
 * @version JolUsage,  2020/5/12 10:30 下午
 */
@Slf4j
public class JolUsage {

    @Test
    public void useJol(){
        log.info("{}", VM.current().details());
        log.info("{}", ClassLayout.parseClass(A.class).toPrintable());
        HashMap hashMap= new HashMap();
        hashMap.put("flydean","www.flydean.com");
        log.info("{}", ClassLayout.parseClass(HashMap.class).toPrintable());
        log.info("{}", ClassLayout.parseInstance(hashMap).toPrintable());
        log.info("{}", GraphLayout.parseInstance(hashMap).toPrintable());
        log.info("{}",ClassLayout.parseClass(String.class).toPrintable());
        log.info("{}",ClassLayout.parseInstance("www.flydean.com").toPrintable());
        log.info("{}",ClassLayout.parseClass(Long.class).toPrintable());
        log.info("{}",ClassLayout.parseInstance(1234567890111112L).toPrintable());
        log.info("{}",ClassLayout.parseClass(Boolean.class).toPrintable());
        log.info("{}",ClassLayout.parseInstance(true).toPrintable());
        log.info("{}",ClassLayout.parseClass(byte[].class).toPrintable());
        log.info("{}",ClassLayout.parseInstance("www.flydean.com".getBytes()).toPrintable());

        log.info("{}",ClassLayout.parseInstance(new HashMap<String,String>()).toPrintable());
        log.info("{}",ClassLayout.parseInstance(new HashMap<String,String>(0)).toPrintable());

    }

    public static class A {
        boolean f;
    }
}
