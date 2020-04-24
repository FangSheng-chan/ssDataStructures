package com.ss.test;

public class t1 {
    public static void main(String[] args) {
        String string = "Java,Java,hello,world!";
        String newStr = string.replaceAll("Java","ss");
        System.out.println("newStr="+newStr);
    }
}
