package com.ss.test;

import java.util.Stack;

public class TestStack {

    public static void main(String[] args) {
        Stack<String> stack = new Stack();
        stack.add("jack");
        stack.add("tom");
        stack.add("ss");
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }
}
