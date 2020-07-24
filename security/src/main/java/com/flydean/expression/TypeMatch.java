package com.flydean.expression;

import java.util.HashSet;

/**
 * @author wayne
 * @version TypeMatch,  2020/7/23
 */
public class TypeMatch {

    public void typeMismatch(){
        HashSet<Short> shortSet= new HashSet<>();
        for(int i=0;i<10;i++){
            shortSet.add((short)i);
            shortSet.remove(i);
        }
        System.out.println(shortSet.size());
    }

    public void typeMatch(){
        HashSet<Short> shortSet= new HashSet<>();
        for(int i=0;i<10;i++){
            shortSet.add((short)i);
            shortSet.remove((short)i);
        }
        System.out.println(shortSet.size());
    }

}
