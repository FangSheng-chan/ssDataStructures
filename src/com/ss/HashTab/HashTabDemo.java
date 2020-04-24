package com.ss.HashTab;

public class HashTabDemo {
    public static void main(String[] args) {

    }
}

//创建HashTab 管理多条链表
class HashTab {
    private EmpLinkedList[] empLinkedListArray;
    private int size; //表示有多少条

    //构造器
    public HashTab(int size) {
        this.size = size;
        empLinkedListArray = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    //添加雇员
    public void add(Emp emp) {
        int empLinkedListNo = hashFun(emp.id);
        empLinkedListArray[empLinkedListNo].add(emp);
    }

    //遍历
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }

    //编写散列函数，使用一个简单的取模法
    public int hashFun(int id) {
        return id % size;
    }
}

//表示雇员
class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

//创建EmpLinkedList,表示链表
class EmpLinkedList {
    private Emp head;


    public void add(Emp emp) {
        System.out.println(head);
        if (head == null) {
            head = emp;
            return;
        }
        //辅助节点
        Emp curEmp = head;
        while (true) {
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next; //后移
        }
        curEmp.next = emp;
    }

    //遍历
    public void list(int no) {
        if (head == null) {
            System.out.println("第"+no+"链表为空");
            return;
        }
        System.out.print("第"+no+"当前链表的信息为：");
        Emp curEmp = head;
        while (true) {
            System.out.printf("=> id=%d name=%s\t", curEmp.id, curEmp.name);
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }
        System.out.println();
    }
}