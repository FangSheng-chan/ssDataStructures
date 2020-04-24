package com.ss.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BubbleSort {


    public static void main(String[] args) {
//        int[] arr = {3, 9, -1, 10, -2};
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000000);
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date = new Date();
        String format = simpleDateFormat.format(date);
        System.out.println("排序前的时间" + format);

        //测试冒泡测试
        bubbleSelect(arr);

        Date date1 = new Date();
        String format1 = simpleDateFormat.format(date1);
        System.out.println(format1);
    }

    public static void bubbleSelect(int[] arr) {
        int temp = 0;
        boolean flag = false;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
//            System.out.println("第" + i + "次排序");
//            System.out.println(Arrays.toString(arr));

            if (!flag) { // 在一趟排序中，一次交换都没有发生过
                break;
            } else {
                flag = false;
            }
        }
    }
}
