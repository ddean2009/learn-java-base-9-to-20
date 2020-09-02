package com.flydean.time;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * @author wayne
 * @version DurationAndPeriod,  2020/9/2
 */
@Slf4j
public class DurationAndPeriod {

    @Test
    public void testDuration(){
        Instant start = Instant.parse("2020-08-03T10:15:30.00Z");
        Instant end = Instant.parse("2020-08-03T10:16:30.12Z");
        Duration duration = Duration.between(start, end);
        log.info("{}",duration.getSeconds());
        log.info("{}",duration.getNano());
        log.info("{}",duration.getUnits());

        duration.plusSeconds(60);
        duration.minus(30, ChronoUnit.SECONDS);
        log.info("{}",duration.isNegative());

        LocalTime start2 = LocalTime.of(1, 20, 25, 1314);
        LocalTime end2 = LocalTime.of(3, 22, 27, 1516);
        Duration.between(start2, end2).getSeconds();

        Duration fromDays = Duration.ofDays(1);
        Duration fromMinutes = Duration.ofMinutes(60);
    }

    @Test
    public void testPeroid(){

        LocalDate startDate = LocalDate.of(2020, 2, 20);
        LocalDate endDate = LocalDate.of(2021, 1, 15);

        Period period = Period.between(startDate, endDate);
        log.info("{}",period.getDays());
        log.info("{}",period.getMonths());
        log.info("{}",period.getYears());

        Period fromUnits = Period.of(3, 10, 10);
        Period fromDays = Period.ofDays(50);
        Period fromMonths = Period.ofMonths(5);
        Period fromYears = Period.ofYears(10);
        Period fromWeeks = Period.ofWeeks(40);

        period.plusDays(50);
        period.minusMonths(2);

    }

    @Test
    public void testChronoUnit(){
        LocalDate startDate = LocalDate.of(2020, 2, 20);
        LocalDate endDate = LocalDate.of(2021, 1, 15);
        long years = ChronoUnit.YEARS.between(startDate, endDate);
        long months = ChronoUnit.MONTHS.between(startDate, endDate);
        long weeks = ChronoUnit.WEEKS.between(startDate, endDate);
        long days = ChronoUnit.DAYS.between(startDate, endDate);
        long hours = ChronoUnit.HOURS.between(startDate, endDate);
        long minutes = ChronoUnit.MINUTES.between(startDate, endDate);
        long seconds = ChronoUnit.SECONDS.between(startDate, endDate);
        long milis = ChronoUnit.MILLIS.between(startDate, endDate);
        long nano = ChronoUnit.NANOS.between(startDate, endDate);
    }
}
