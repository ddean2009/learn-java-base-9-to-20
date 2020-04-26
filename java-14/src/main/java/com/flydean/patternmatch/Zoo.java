package com.flydean.patternmatch;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author wayne
 * @version Zoo,  2020/4/26 4:24 下午
 */
@Slf4j
public class Zoo {

    public void testZooOld(Object animal){
        if(animal instanceof Girraffe){
            Girraffe girraffe = (Girraffe) animal;
            log.info("girraffe name is {}",girraffe.getName());
        }else if(animal instanceof Hippo){
            Hippo hippo = (Hippo) animal;
            log.info("hippo name is {}",hippo.getName());
        }
        throw new IllegalArgumentException("对不起，该动物不是地球上的生物！");
    }

    public void testZooNew(Object animal){
        if(animal instanceof Girraffe girraffe){
            log.info("name is {}",girraffe.getName());
        }else if(animal instanceof Hippo hippo){
            log.info("name is {}",hippo.getName());
        }
        throw new IllegalArgumentException("对不起，该动物不是地球上的生物！");
    }

}
