package com.flydean.expression;

import java.util.Collection;

/**
 * @author wayne
 * @version NullObject,  2020/7/23
 */
public class NullObject {

    public int countWrong(Collection<Object> collection, Object object){
        int count=0;
        if(collection ==null){
            return count;
        }
        for(Object element: collection){
            if((element ==null && object== null)
                || element.equals(object)){
                count++;
            }
        }
        return count;
    }

    public int countRight(Collection<Object> collection, Object object){
        int count=0;
        if(collection ==null){
            return count;
        }
        for(Object element: collection){
            if((element ==null && object== null)
                    || (element !=null && element.equals(object))){
                count++;
            }
        }
        return count;
    }

    public void streamWrong(Collection<Object> collection){
        collection.stream().filter(obj->obj.equals("www.flydean.com"));
    }
}
