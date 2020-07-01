package com.flydean;

/**
 * @author wayne
 * @version TestVirtualCall,  2020/6/29 10:06 下午
 */
public class TestVirtualCall4 {

    public static void main(String[] args) throws InterruptedException {
        CustObj obj = new CustObj();
        CustObj2 obj2 = new CustObj2();
        CustObj3 obj3 = new CustObj3();
        for (int i = 0; i < 10000; i++)
        {
            doWithVMethod(obj);
            doWithVMethod(obj2);
            doWithVMethod(obj3);

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
    private static class CustObj2 extends  CustObj
    {
        public final void methodCall()
        {
            if(System.currentTimeMillis()== 0){
                System.out.println("CustObj2 is very good!");
            }
        }
    }
    private static class CustObj3 extends  CustObj
    {
        public final void methodCall()
        {
            if(System.currentTimeMillis()== 0){
                System.out.println("CustObj3 is very good!");
            }
        }
    }
}
