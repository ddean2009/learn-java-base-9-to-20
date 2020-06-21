package com.flydean;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

/**
 * @author wayne
 * @version StringInternJOL,  2020/6/21 8:50 上午
 */
@Slf4j
public class StringInternJOL {

    @Test
    public void useJol() {
        log.info("{}", ClassLayout.parseInstance(new String(new char[]{'a','b','c'})).toPrintable());
        log.info("{}", ClassLayout.parseInstance(new String("abc")).toPrintable());
        log.info("{}", ClassLayout.parseInstance(new String(new char[]{'a','b','c'}).intern()).toPrintable());
        log.info("{}", ClassLayout.parseInstance("www.flydean.com".intern()).toPrintable());
    }
}
