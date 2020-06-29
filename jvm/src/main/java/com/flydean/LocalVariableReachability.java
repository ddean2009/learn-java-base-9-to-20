package com.flydean;

public class LocalVariableReachability {

    private static volatile boolean flag;

    static {
        new Thread(() -> {
                while (true) {
                    System.gc();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }).start();
    }

    public static void resetFlag() {
        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = false;
        }).start();
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("开始测试1");
        resetFlag();
        flag = true;
        testLocalVariable();

        System.out.println("等待Test1结束");
        Thread.sleep(10000);

        System.out.println("开始测试2");
        flag = true;
        testLocalVariable();
    }

    public static void testLocalVariable() {
        Test test1 = new Test();
        Test test2 = new Test();
        while (flag) {
            // 啥都不做
        }
        test1.test();
    }

    public static class Test {
       public Test() {
           System.out.println("创建对象 " + this);
       }

       public void test() {
           System.out.println("测试对象 " + this);
       }

       @Override
       protected void finalize() throws Throwable {
           System.out.println("回收对象 " + this);
       }
    }

}
