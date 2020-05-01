package com.flydean;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wayne
 * @version TeeingCollector,  2020/4/30 11:11 上午
 */
@Slf4j
public class TeeingCollector {

    @Test
    public void useTeeing(){
        List<Student> studentList= Arrays.asList(
                new Student("alice", 90),
                new Student("boy", 20),
                new Student("bruce", 40),
                new Student("batman", 100)
        );
        String teeingResult=studentList.stream().collect(
                Collectors.teeing(
                        Collectors.averagingInt(Student::getScore),
                        Collectors.summingInt(Student::getScore),
                        (s1,s2)-> s1+ ":"+ s2
                )
        );
        log.info(teeingResult);
    }
}
