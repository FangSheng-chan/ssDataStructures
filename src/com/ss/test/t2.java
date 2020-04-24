package com.ss.test;

public class t2 {
    public static void main(String[] args) {
        int chessArr1[][] = new int[11][11];
//        chessArr1[1][2] = 1;
//        chessArr1[2][3] = 2;
//        chessArr1[3][4] = 6;
//        //输出原始的二维数组
//        System.out.println("原始的二维数组....");
//        for (int[] row : chessArr1) {
//            for (int data : row) {
//                System.out.printf("%d\t", data);
//            }
//            System.out.println();
//        }
        System.out.println("\n\n");
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                System.out.printf("%d\t", chessArr1[i][j]);
            }
            System.out.println();
        }
    }
}
