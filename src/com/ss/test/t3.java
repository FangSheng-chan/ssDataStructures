package com.ss.test;

import java.util.Scanner;

public class t3 {
    public static void main(String[] args) {
        System.out.println("[A 加密][J 解密],请选择一个");
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        if (s1.equalsIgnoreCase("A")) {
            System.out.println("请输入明文");
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            System.out.println("请输入密钥：");
            Scanner scanner1 = new Scanner(System.in);
            int key = scanner1.nextInt();
            Encryption(s, key);
        } else if (s1.equalsIgnoreCase("J")) {
            System.out.println("请输入密文：");
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            System.out.println("请输入密钥：");
            Scanner scanner1 = new Scanner(System.in);
            int key = scanner1.nextInt();
            Decryption(s, key);
        }
    }

    private static void Decryption(String s, int key) {
        //解密
        int k = Integer.parseInt("-" + key);
        String string = "";
        for (int i = 0; i < s.length(); i++) {
            //charAt() 方法用于返回指定索引处的字符。索引范围为从 0 到 length() - 1。
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                c += k % 26;
                if (c < 'a') {
                    c += 26;
                }
                if (c > 'z') {
                    c -= 26;
                }
            } else if (c >= 'A' && c <= 'Z') {
                c += k % 26;
                if (c < 'A') {
                    c += 26;
                }
                if (c > 'Z') {
                    c -= 26;
                }
            }
            string += c;
        }
        System.out.println(s + "解密后：" + string);
    }

    private static void Encryption(String s, int key) {
        //加密
        String string = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                c += key % 26;
                if (c < 'a') {
                    c += 26;
                }
                if (c > 'z') {
                    c -= 26;
                }
            } else if (c >= 'A' && c <= 'Z') {
                c += key % 26;
                if (c < 'A') {
                    c += 26;
                }
                if (c > 'Z') {
                    c -= 26;
                }
            }
            string += c;
        }
        System.out.println(s + "加密后：" + string);
    }
}
