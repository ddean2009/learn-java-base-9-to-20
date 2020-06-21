package com.flydean;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

/**
 * @author wayne
 * @version CacheLineJOL,  2020/6/19 8:53 上午
 */
@Slf4j
public class CacheLineJOL {
    @Test
    public void useJol() {
        log.info("{}", ClassLayout.parseClass(CacheLine.class).toPrintable());
        log.info("{}", ClassLayout.parseInstance(new CacheLine()).toPrintable());
        log.info("{}", ClassLayout.parseClass(CacheLinePadded.class).toPrintable());
        log.info("{}", ClassLayout.parseInstance(new CacheLinePadded()).toPrintable());
    }
}
