package com.flydean.uswitch;

import org.junit.Test;

import static java.util.Calendar.*;

/**
 * @author wayne
 * @version SwitchUsage,  2020/4/27 5:05 下午
 */
public class SwitchUsage {

    @Test
    public void useOldSwitch(){
        switch (MONDAY) {
            case MONDAY:
            case FRIDAY:
            case SUNDAY:
                System.out.println(6);
                break;
            case TUESDAY:
                System.out.println(7);
                break;
            case THURSDAY:
            case SATURDAY:
                System.out.println(8);
                break;
            case WEDNESDAY:
                System.out.println(9);
                break;
        }
    }

    @Test
    public void useNewSwitch(){
        switch (MONDAY) {
            case MONDAY, FRIDAY, SUNDAY -> System.out.println(6);
            case TUESDAY                -> System.out.println(7);
            case THURSDAY, SATURDAY     -> System.out.println(8);
            case WEDNESDAY              -> System.out.println(9);
        }
    }

    @Test
    public void oldSwitchWithReturnValue(){
        int numLetters;
        switch (MONDAY) {
            case MONDAY:
            case FRIDAY:
            case SUNDAY:
                numLetters = 6;
                break;
            case TUESDAY:
                numLetters = 7;
                break;
            case THURSDAY:
            case SATURDAY:
                numLetters = 8;
                break;
            case WEDNESDAY:
                numLetters = 9;
                break;
            default:
                throw new IllegalStateException("这天没发见人！");
        }
    }

    @Test
    public void newSwitchWithReturnValue(){
        int numLetters = switch (MONDAY) {
            case MONDAY, FRIDAY, SUNDAY -> 6;
            case TUESDAY                -> 7;
            case THURSDAY, SATURDAY     -> 8;
            case WEDNESDAY              -> 9;
            default -> throw new IllegalStateException("这天没发见人!");
        };
    }

    @Test
    public void withYield(){
        int result = switch (MONDAY) {
            case MONDAY: {
                yield 1;
            }
            case TUESDAY: {
                yield 2;
            }
            default: {
                System.out.println("不是MONDAY，也不是TUESDAY！");
                yield 0;
            }
        };
    }
}
