package com.flydean;

import java.io.IOException;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        streamWithCheckedException();
//        sneakyThrow();
        sneakyThrowFinal();
    }

    public static void streamWithCheckedException(){
        Stream.of(new MyStudents()).map(s-> {
            try {
                return s.changeAgeWithCheckedException();
            } catch (MyCheckedException e) {
                throw new RuntimeException(e);
            }
        }).toList();
    }

    public static void streamWithUncheckedException(){
        Stream.of(new MyStudents()).map(MyStudents::changeAgeWithUnCheckedException).toList();
    }

    public static void sneakyThrow(){
        try {
            Stream.of(new MyStudents()).map(s -> SneakilyThrowException.sneakyThrow(new IOException())).toList();
        }catch (Exception e){
           System.out.println("get exception");
        }
    }

    public static void sneakyThrowFinal(){
        try {
            Stream.of(new MyStudents()).map(SneakilyThrowException.unchecked(MyStudents::changeAgeWithCheckedException)).toList();
        }catch (Exception e){
            System.out.println("get exception");
        }
    }


}