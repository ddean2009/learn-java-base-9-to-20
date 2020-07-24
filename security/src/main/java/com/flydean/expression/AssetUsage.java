package com.flydean.expression;

import java.util.ArrayList;

/**
 * @author wayne
 * @version AssetUsage,  2020/7/23
 */
public class AssetUsage {

    public void assetWrong(ArrayList<Integer> list){
        assert  list.remove(0)>0;
    }

    public void assetRight(ArrayList<Integer> list){
        int result=list.remove(0);
        assert  result>0;
    }

}
