package com.flydean;

import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author wayne
 * @version VarGenericity,  2020/5/4 11:32 上午
 */
public class VarGenericity {

    public Object createList(boolean flag){
        if(flag){
            return new ArrayList<>();
        }else{
            return new CopyOnWriteArrayList<>();
        }
    }

    public <E> ListInterface<E> createListWithInterface(boolean flag){
        if(flag){
            return (ListInterface<E>) new ArrayList<E>();
        }else{
            return (ListInterface<E>) new CopyOnWriteArrayList<E>();
        }
    }

    public <T extends List<E> & RandomAccess &  Cloneable & java.io.Serializable, E> T createListWithInterfaceT(boolean flag){
        if(flag){
            return (T) new ArrayList<E>();
        }else{
            return (T) new CopyOnWriteArrayList<E>();
        }
    }

    public <T extends List<E> & RandomAccess &  Cloneable & java.io.Serializable, E> void useGenericityType(){
        VarGenericity varGenericity=new VarGenericity();
        T list=varGenericity.createListWithInterfaceT(true);
    }

    public void useVarInGenericityType(){
        VarGenericity varGenericity=new VarGenericity();
        var list=varGenericity.createListWithInterfaceT(true);
    }




}
