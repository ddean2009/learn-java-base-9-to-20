package com.flydean.object;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author wayne
 * @version HeapPollution,  2020/7/25
 */
public class HeapPollution {

    @Test
    public void heapPollution1(){
        List normalList= Arrays.asList("www.flydean.com",100);
        List<Integer> integerList= normalList;
    }

    private void addToList(List list, Object object){
        list.add(object);
    }

    @Test
    public void heapPollution2(){
        List<Integer> integerList=new ArrayList<>();
        addToList(integerList,"www.flydean.com");
    }

    @Test
    public void heapPollutionRight(){
        List<Integer> integerList=new ArrayList<>();
        List<Integer> checkedIntegerList= Collections.checkedList(integerList, Integer.class);
        addToList(checkedIntegerList,"www.flydean.com");
    }

    private <T> void addToList2(List<T> list, T t) {
        list.add(t);
    }

    public <T> void heapPollutionRight2(T element){
        List<T> list = new ArrayList<>();
        addToList2(list,element);
    }

    private void addToList3(List<Integer>... listArray){
        Object[] objectArray = listArray;
        objectArray[0]= Arrays.asList("www.flydean.com");
        for(List<Integer> integerList: listArray){
            for(Integer element: integerList){
                System.out.println(element);
            }
        }
    }

    private void addToList4(List<List<Integer>> listArray){
//        listArray.set(0,Arrays.asList("www.flydean.com"));
//        for(List<Integer> integerList: listArray){
//            for(Integer element: integerList){
//                System.out.println(element);
//            }
//        }
    }
}
