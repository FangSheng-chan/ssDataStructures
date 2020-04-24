package com.ss.search;

import java.util.ArrayList;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1, 8, 10, 89, 1000, 1000, 1000, 1000, 1000, 1234};

        ArrayList<Integer> list = binarySearch2(arr, 0, arr.length - 1, 1000);


        System.out.println("resIndex=" + list);

    }

    //二分查找

    /**
     * @param arr
     * @param left
     * @param right
     * @param findVal
     * @return
     */
    public static int binarySearch(int[] arr, int left, int right, int findVal) {

        //当left > right 时，说明递归整个数组，但是没有找到
        if (left > right){
            return -1;
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (findVal > midVal) { //向右递归
            return binarySearch(arr, mid +1, right, findVal);
        } else if (findVal < midVal) { //向左递归
            return binarySearch(arr, left, mid -1, findVal);
        } else {
            return mid;
        }
    }


    public static ArrayList<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {

        //当left > right 时，说明递归整个数组，但是没有找到
        if (left > right) {
            return new ArrayList<Integer>();
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (findVal > midVal) { //向右递归
            return binarySearch2(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) { //向左递归
            return binarySearch2(arr, left, mid - 1, findVal);
        } else {
            ArrayList<Integer> resIndexList = new ArrayList<>();
            //向mid索引值的左边扫描，将所有满足1000的元素的下标，加入到集合ArrayList
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                }
                resIndexList.add(temp);
                temp -= 1;
            }
            resIndexList.add(mid);
            //向mid索引值的右边扫描，将所有满足1000的元素的下标，加入到集合ArrayList
            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findVal) {
                    break;
                }
                resIndexList.add(temp);
                temp += 1;
            }
            return resIndexList;
        }
    }

}


