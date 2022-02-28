package com.homeward.webstore;

public class TestFinalize {
    public boolean switchhh = true;

    public TestFinalize() {
        System.out.println("构造");
    }


    public TestFinalize(boolean switchhh) {
        this.switchhh = switchhh;
        System.out.println("构造:switchhh");
    }

    public void changeee() {
        this.switchhh = false;
        System.out.println("方法:changeee");
    }

    // protected void finalize() {
    //     System.out.println("方法:finalize");
    //     if (switchhh) {
    //         System.out.println("true");
    //     }
    // }

    public static void main(String[] args) {
        TestFinalize a = new TestFinalize(true);
        a.changeee();
        new TestFinalize(true);
        System.gc();
    }
}
