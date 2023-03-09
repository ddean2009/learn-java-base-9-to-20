package com.flydean;

public class MyStudents {

    public int changeAgeWithCheckedException() throws MyCheckedException {
        throw new MyCheckedException();
    }

    public int changeAgeWithUnCheckedException(){
        throw new RuntimeException();
    }
}
