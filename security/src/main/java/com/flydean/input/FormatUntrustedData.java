package com.flydean.input;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author wayne
 * @version FormatUntrustedData,  2020/7/27
 */
public class FormatUntrustedData {

    @Test
    public void wrongFormat(){
        Calendar c = new GregorianCalendar(2020, GregorianCalendar.JULY, 27);
        String input=" %1$tm";
        System.out.format(input + " 时间不匹配，应该是某个月的第 %1$terd 天", c);
    }

    @Test
    public void rightFormat(){
        Calendar c = new GregorianCalendar(2020, GregorianCalendar.JULY, 27);
        String input=" %1$tm";
        System.out.format("%s 时间不匹配，应该是某个月的第 %terd 天",input, c);
    }
}
