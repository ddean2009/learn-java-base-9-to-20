package com.flydean;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wayne
 * @version CollectionSize,  2020/6/18 3:24 下午
 */
@Slf4j
public class CollectionSize {

    @Test
    public void useJol(){
        //byte array
        log.info("{}",ClassLayout.parseInstance("www.flydean.com".getBytes()).toPrintable());
        //String
        log.info("{}",ClassLayout.parseInstance("www.flydean.com").toPrintable());
        //Array List
        log.info("{}",ClassLayout.parseInstance(new ArrayList()).toPrintable());
        //HashMap
        log.info("{}",ClassLayout.parseInstance(new HashMap()).toPrintable());
        //HashSet
        log.info("{}",ClassLayout.parseInstance(new HashSet()).toPrintable());
        //LinkedList
        log.info("{}",ClassLayout.parseInstance(new LinkedList<>()).toPrintable());
        //TreeMap
        log.info("{}",ClassLayout.parseInstance(new TreeMap<>()).toPrintable());
        //ConcurrentHashMap
        log.info("{}",ClassLayout.parseInstance(new ConcurrentHashMap<>()).toPrintable());
    }
}
