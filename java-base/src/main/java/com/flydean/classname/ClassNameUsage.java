package com.flydean.classname;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author wayne
 * @version ClassNameUsage,  2020/4/28 3:19 下午
 */
@Slf4j
public class ClassNameUsage {

    @Test
    public void testClassName(){
        //primary class
        log.info(int.class.getName());
        log.info(short.class.getName());
        log.info(float.class.getName());
        log.info(double.class.getName());
        log.info(long.class.getName());
        log.info(byte.class.getName());
        log.info(char.class.getName());
        log.info(boolean.class.getName());
        //void
        log.info(void.class.getName());

        //object class
        log.info(Object.class.getName());

        //Array
        log.info(int[].class.getName());
        log.info(short[].class.getName());
        log.info(float[].class.getName());
        log.info(double[].class.getName());
        log.info(long[].class.getName());
        log.info(byte[].class.getName());
        log.info(char[].class.getName());
        log.info(boolean[].class.getName());
        log.info(Object[].class.getName());

        //multiple arrays
        log.info(int[][][].class.getName());



    }
}
