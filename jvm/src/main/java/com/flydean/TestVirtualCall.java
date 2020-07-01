package com.flydean;

/**
 * @author wayne
 * @version TestVirtualCall,  2020/6/29 10:06 下午
 */
public class TestVirtualCall {

    public static void main(String[] args) throws InterruptedException {
        CustObj obj = new CustObj();
        for (int i = 0; i < 10000; i++)
        {
            doWithVMethod(obj);
        }
        Thread.sleep(1000);
    }

    public static void doWithVMethod(CustObj obj)
    {
        obj.methodCall();
    }

    private static class CustObj
    {
        public void methodCall()
        {
            if(System.currentTimeMillis()== 0){
                System.out.println("CustObj is very good!");
            }
        }
    }
}
