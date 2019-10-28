package com.ly.sort;

public class II {

    public static void main(String[] args) {
        short s = 1 ;
        s = s++;
        s += 1;
        int a = s +1;

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            int b = 1;
        }
    }
}
