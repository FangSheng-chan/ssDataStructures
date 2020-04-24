package com.ss.tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");

        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);

//        System.out.println("前序遍历");
//        binaryTree.preOrder();

//        System.out.println("中序遍历");
//        binaryTree.infixOrder();

//        System.out.println("后序遍历");
//        binaryTree.postOrder();

        System.out.println("前序遍历方式--------");
        HeroNode resNode = binaryTree.preOrderSearch(5);
        if (resNode != null) {
            System.out.printf("找打了，信息为no = %d name = %s",resNode.getNo(),resNode.getName());
        }else {
            System.out.printf("没有找到 no=%d 的英雄",5);
        }
    }

    //定义有个二叉树
    static class BinaryTree {
        private HeroNode root;

        public void setRoot(HeroNode root) {
            this.root = root;
        }

        //前序遍历
        public void preOrder() {
            if (this.root != null) {
                this.root.preOrder();
            } else {
                System.out.println("二叉树为空，无法遍历");
            }
        }

        //中序遍历
        public void infixOrder() {
            if (this.root != null) {
                this.root.infixOrder();
            } else {
                System.out.println("二叉树为空，无法遍历");
            }
        }

        //后序遍历
        public void postOrder() {
            if (this.root != null) {
                this.root.postOrder();
            } else {
                System.out.println("二叉树为空，无法遍历");
            }
        }

        //前序遍历查找
        public HeroNode preOrderSearch(int no) {
            if (root != null) {
                return root.preOrdersearch(no);
            } else {
                return null;
            }
        }
        public HeroNode infixOrderSearch(int no) {
            if (root != null) {
                return root.infixOrdersearch(no);
            } else {
                return null;
            }
        }
        public HeroNode postOrderSearch(int no) {
            if (root != null) {
                return root.postOrderSearch(no);
            } else {
                return null;
            }
        }
    }

    //先创建HeroNode节点
    static class HeroNode {
        private int no;
        private String name;
        private HeroNode left;
        private HeroNode right;

        public HeroNode(int no, String name) {
            this.no = no;
            this.name = name;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public HeroNode getLeft() {
            return left;
        }

        public void setLeft(HeroNode left) {
            this.left = left;
        }

        public HeroNode getRight() {
            return right;
        }

        public void setRight(HeroNode right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name +
                    '}';
        }

        //编写前序遍历的方法
        public void preOrder() {
            System.out.println(this);
            //递归向左子树前序遍历
            if (this.left != null) {
                this.left.preOrder();
            }
            if (this.right != null) {
                this.right.preOrder();
            }
        }

        //中序遍历
        public void infixOrder() {
            if (this.left != null) {
                this.left.infixOrder();
            }
            System.out.println(this);
            if (this.right != null) {
                this.right.infixOrder();
            }
        }

        //后序遍历
        public void postOrder() {
            if (this.left != null) {
                this.left.postOrder();
            }
            if (this.right != null) {
                this.right.postOrder();
            }
            System.out.println(this);
        }

        //前序查找

        /**
         * @param no
         * @return
         */
        public HeroNode preOrdersearch(int no) {
            if (this.no == no) {
                return this;
            }
            HeroNode resNode = null;
            if (this.left != null) {
                resNode = this.left.preOrdersearch(no);
            }
            if (resNode != null) {
                return resNode;
            }
            if (this.right != null) {
                resNode = this.right.preOrdersearch(no);
            }
            return resNode;
        }

        public HeroNode infixOrdersearch(int no) {
            HeroNode resNode = null;
            if (this.left != null) {
                resNode = this.left.infixOrdersearch(no);
            }
            if (resNode != null) {
                return resNode;
            }
            if (this.no == no) {
                return this;
            }
            if (this.right != null) {
                resNode = this.right.infixOrdersearch(no);
            }
            return resNode;
        }

        public HeroNode postOrderSearch(int no) {
            HeroNode resNode = null;
            if (this.left != null) {
                resNode = this.left.postOrderSearch(no);
            }
            if (resNode != null) {
                return resNode;
            }

            if (this.right != null) {
                resNode = this.right.postOrderSearch(no);
            }
            if (this.no == no) {
                return this;
            }
            return resNode;
        }
    }


}
