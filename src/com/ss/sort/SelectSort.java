package com.ss.sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};
        selectSort(arr);

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            // 将最小值，放在arr[i], 即交换
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
            System.out.println("第" + (i + 1) + "轮后~~");
            System.out.println(Arrays.toString(arr));// 1, 34, 119, 101
        }
    }

    //选择排序
    public static void selectSort(int[] arr) {
//        int minIndex = 0;
//        int min = arr[0];
//        for (int j = 0 + 1; j < arr.length; j++) {
//            if (min > arr[j]) {
//                min = arr[j];
//                minIndex = j;
//            }
//        }
//        arr[minIndex] = arr[0];
//        arr[0] = min;
//        System.out.println("第一轮....");
//        System.out.println(Arrays.toString(arr));
//
//
//        minIndex = 1;
//        min = arr[1];
//        for (int j = 1 + 1; j < arr.length; j++) {
//            if (min > arr[j]) {
//                min = arr[j];
//                minIndex = j;
//            }
//            // 将最小值，放在arr[1], 即交换
//            if (minIndex != 1) {
//                arr[minIndex] = arr[1];
//                arr[1] = min;
//            }
//        }
//        System.out.println("第2轮....");
//        System.out.println(Arrays.toString(arr));
//
//        minIndex = 2;
//        min = arr[2];
//        for (int j = 1 + 1; j < arr.length; j++) {
//            if (min > arr[j]) {
//                min = arr[j];
//                minIndex = j;
//            }
//            // 将最小值，放在arr[2], 即交换
//            if (minIndex != 2) {
//                arr[minIndex] = arr[2];
//                arr[2] = min;
//            }
//        }
//        System.out.println("第3轮....");
//        System.out.println(Arrays.toString(arr));
    }
}
