package com.flydean;

import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.Annotation;
import java.util.stream.Stream;

/**
 * @author wayne
 * @version CustUser,  2020/5/5 10:42 下午
 */
@Slf4j
@CustUserAnnotation(value = 100, name="jack ma",addresses = {"人民路","江西路"})
public class CustUser {

    public static void main(String[] args) {
        CustUser custUser= new CustUser();
        Annotation[] annotations= custUser.getClass().getAnnotations();
        Stream.of(annotations).filter(annotation -> annotation instanceof CustUserAnnotation)
                .forEach(annotation -> log.info(((CustUserAnnotation) annotation).name()));
    }
}
