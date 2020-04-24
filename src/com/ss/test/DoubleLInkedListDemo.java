package com.ss.test;

public class DoubleLInkedListDemo {
    public static void main(String[] args) {

    }


    //创建一个双向链表的类
    class DoubleLinkedList {

        //先定义一个头节点，头节点不要动，不要放具体的数据
        private HeroNode2 head = new HeroNode2(0, "", "");

        public HeroNode2 getHead() {
            return head;
        }

        //遍历双向链表
        public void list() {
            if (head.next == null) {
                System.out.println("链表为空");
                return;
            }
            //因为头节点不能动，因此我们需要一个辅助变量来遍历
            HeroNode2 temp = head.next;
            while (true) {
                if (temp == null) {
                    break;
                }
                System.out.println(temp);
                //将temp后移
                temp = temp.next;
            }
        }

        //添加一个节点到双向链表的最后
        public void add(HeroNode2 heroNode) {
            HeroNode2 temp = head;
            while (true) {
                if (temp.next == null) {
                    break;
                }
                temp = temp.next;

            }
            temp.next = heroNode;
            heroNode.pre = temp;

        }

        public void update(HeroNode2 newHeroNode) {
            //判断是否为空
            if (head.next == null) {
                System.out.println("链表为空...");
            }
            HeroNode2 temp = head;
            boolean flag = false;
            while (true) {
                if (temp == null) {
                    break; //已经遍历完
                }
                if (temp.no == newHeroNode.no) {
                    //找到
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

        public void del(int no) {
            if (head.next == null) {
                System.out.println("链表为空");
                return;
            }
            HeroNode2 temp = head.next;
            boolean flag = false;
            while (true) {
                if (temp == null) {
                    break;
                }
                if (temp.no == no) {
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            if (flag) {
                temp.pre.next = temp.next;
                if (temp.next == null) {
                    temp.next.pre = temp.pre;
                }
            }   else {
                System.out.printf("要删除的 %d 节点不存在\n", no);
            }
        }
    }


    //定义一个HeroNode2类
    class HeroNode2 {
        public int no;
        public String name;
        public String nickName;
        public HeroNode2 next;
        public HeroNode2 pre;

        //构造器
        public HeroNode2(int no, String name, String nickName) {
            this.no = no;
            this.name = name;
            this.nickName = nickName;
        }

        //为了显示方法，我们重新toString

        @Override
        public String toString() {
            return "HeroNode2{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickName='" + nickName + '\'' +
                    '}';
        }
    }
}















