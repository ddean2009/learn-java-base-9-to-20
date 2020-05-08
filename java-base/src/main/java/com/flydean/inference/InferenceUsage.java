package com.flydean.inference;

import java.util.Comparator;
import java.util.stream.Stream;

/**
 * @author wayne
 * @version InferenceUsage,  2020/5/7 11:00 上午
 */
public class InferenceUsage {

    public static void testStream(){
        Stream.of(new CustUser(10,"alice"), new CustUser(20,"bluce"))
                .forEach( (CustUser custUser)-> System.out.println(custUser.name));
    }

    public static void testInference(){
        Stream.of(new CustUser(10,"alice"), new CustUser(20,"bluce"))
                .forEach(custUser-> System.out.println(custUser.name));
    }

    public static Comparator<CustUser> createUser1(){
        return (CustUser user1, CustUser user2) -> user1.getAge() - user2.getAge();
    }

    public static Comparator<CustUser> createUser2(){
//        Comparator comparator=(user1, user2) -> user1.getAge() - user2.getAge();
        return (user1, user2) -> user1.getAge() - user2.getAge();
    }

    public static Comparator<CustUser> createUser3(){
        Comparator<CustUser> comparator=(CustUser user1, CustUser user2) -> user1.getAge() - user2.getAge();
        return comparator.reversed();
    }

    public static Comparator<CustUser> createUser4(){
        Comparator<CustUser> comparator=(user1,user2) -> user1.getAge() - user2.getAge();
        return comparator.reversed();
    }

    public static Comparator<CustUser> createUser5(){
        return ((Comparator<CustUser>)((CustUser user1, CustUser user2) -> user1.getAge() - user2.getAge())).reversed();
    }

    public static Comparator<CustUser> createUser6(){
        return ((Comparator<CustUser>)((user1, user2) -> user1.getAge() - user2.getAge())).reversed();
    }

}
