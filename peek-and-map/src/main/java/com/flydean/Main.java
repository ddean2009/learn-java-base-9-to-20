package com.flydean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.Stream;

@Slf4j
public class Main {
    public static void main(String[] args) {
//        peekOne();
//        peekForEach();
        peekLazy();
//        peekNotExecute();
//        mapNotExecute();
//        peekUnModified();
//        mapModified();
//        peekModified();
    }

    public static void peekOne(){
        Stream.of(1, 2, 3)
                .peek(e -> log.info(String.valueOf(e)))
                .toList();
    }

    public static void peekForEach(){
        Stream.of(1, 2, 3)
                .peek(e -> log.info(String.valueOf(e)))
                .forEach(e->log.info("forEach"+e));
    }

    public static void peekLazy(){
        Stream.of(1, 2, 3)
                .peek(e -> log.info(String.valueOf(e)));
    }

    public static void peekNotExecute(){
        Stream.of(1, 2, 3)
                .peek(e -> log.info("peekNotExecute"+e))
                .count();
    }

    public static void mapNotExecute(){
       Stream.of(1,2,3)
                .map(e -> {
                    log.info("mapNotExecute:"+e);
                    e=e+1;
                    return e;
                })
               .count();
    }

    public static void peekUnModified(){
        Stream.of(1, 2, 3)
                .peek(e -> e=e+1)
                .forEach(e->log.info("peek unModified"+e));
    }

    public static void mapModified(){
        Stream.of(1, 2, 3)
                .map(e -> e=e+1)
                .forEach(e->log.info("map modified"+e));
    }

    public static void peekModified(){
        Stream.of(new User(1), new User(2), new User(3))
                .peek(e -> e.setAge(4))
                .forEach(e->log.info("peek peekModified"+e));
    }

}

@Data
@AllArgsConstructor
class User{
    int age;
}