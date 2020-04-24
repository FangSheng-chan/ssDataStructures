package com.ss.test;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {

        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建要给的链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();


        singleLinkedList.add(hero1);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero4);

        singleLinkedList.list();

        HeroNode newHeroNode = new HeroNode(2, "ss", "7777");
        singleLinkedList.update(newHeroNode);

        System.out.println("\n");

        singleLinkedList.list();
        System.out.println("\n");
        singleLinkedList.del(1);
        singleLinkedList.list();

        System.out.println("\n");

        int length = getLength(singleLinkedList.getHead());
        System.out.println(length);

        HeroNode lastIndexNode = findLastIndexNode(singleLinkedList.getHead(), 2);
        System.out.println(lastIndexNode);

        System.out.println("原来的链表：");
        singleLinkedList.list();

        System.out.println("逆序打印单链表");
        reversePrint(singleLinkedList.getHead());
    }

    public static void reversePrint(HeroNode head){
        if (head.next == null){
            return;
        }
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.next;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        while (stack.size() >0){
            System.out.println(stack.pop());
        }
    }

    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        if (head.next == null) {
            return null;
        }
        int size = getLength(head);
        if (index <= 0 || index > size) {
            return null;
        }
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public static int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    static class SingleLinkedList {
        //初始化头节点
        private HeroNode head = new HeroNode(0, "", "");

        //返回头节点
        public HeroNode getHead() {
            return head;
        }

        public void del(int no){
            HeroNode temp = head;
            boolean flag = false;
            while (true){
                if (temp.next == null) {
                    break;
                }
                if (temp.next.no == no){
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            if (flag){
                temp.next = temp.next.next;
            }else{
                System.out.printf("要删除的 %d 节点不存在 \n",no);
            }
        }

        public void update(HeroNode newHeroNode) {
            if (head.next == null) {
                System.out.println("链表为空");
                return;
            }
            HeroNode temp = head.next;
            boolean flag = false;
            while (true) {
                if (temp == null) {
                    break;
                }
                if (temp.no == newHeroNode.no) {
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            if (flag) {
                temp.name = newHeroNode.name;
                temp.nickName = newHeroNode.nickName;
            } else {
                System.out.printf("没有找到 编号 %d 的节点，不能修改\n", newHeroNode.no);
            }
        }

        public void addOrder(HeroNode heroNode) {
            HeroNode temp = head;
            boolean flag = false;
            while (true) {
                if (temp.next == null) {
                    break;
                }
                if (temp.next.no > heroNode.no) {
                    break;
                } else if (temp.next.no == heroNode.no) {
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            if (flag) {
                System.out.printf("准备插入的英雄编号 %d 已经存在，不能加入\n", heroNode.no);
            } else {
                HeroNode next = temp.next;
                temp.next = heroNode;
            }
        }


        public void add(HeroNode heroNode) {
            //因为head节点不能动，因此我们需要一个辅助遍历temp
            HeroNode temp = head;
            //遍历链表，找到最后
            while (true) {
                //找到链表的最后
                if (temp.next == null) {
                    break;
                }
                //如果没有找到最后，就将temp后移
                temp = temp.next;
            }
            temp.next = heroNode;
        }

        //显示链表【遍历】
        public void list() {
            //判断链表是否为空
            if (head.next == null) {
                System.out.println("链表为空");
                return;
            }
            //因为头节点不能动，因此我们需要一个辅助变量来遍历
            HeroNode temp = head.next;
            while (true) {
                //判断是否到链表的最后
                if (temp == null) {
                    break;
                }
                //输出节点的信息
                System.out.println(temp);
                temp = temp.next;
            }
        }
    }


    //定义HeroNode,每个HeroNode对象就是一个节点
    static class HeroNode {
        private int no;
        private String name;
        private String nickName;
        private HeroNode next;

        //构造器
        public HeroNode(int no, String name, String nickName) {
            this.no = no;
            this.name = name;
            this.nickName = nickName;
        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickName='" + nickName + '\'' +
                    '}';
        }
    }
}
