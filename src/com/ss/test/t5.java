package com.ss.test;

import java.util.Arrays;
import java.util.List;

public class t5 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("ss", "dd", "zz");
        System.out.println(list);
        list.forEach(System.out::println);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));

        }
    }
}
