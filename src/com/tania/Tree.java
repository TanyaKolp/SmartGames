package com.tania;


/**
 * Created by tania on 27.02.17.
 */
public class Tree {
    public TreeNodeImpl setRoot() {
        TreeNodeImpl root = new TreeNodeImpl(8);
        TreeNodeImpl ch1 = new TreeNodeImpl(3);
        TreeNodeImpl ch11 = new TreeNodeImpl(1);
        TreeNodeImpl ch12 = new TreeNodeImpl(6);
        TreeNodeImpl ch121 = new TreeNodeImpl(4);
        TreeNodeImpl ch122 = new TreeNodeImpl(7);
        TreeNodeImpl ch2 = new TreeNodeImpl(10);
        TreeNodeImpl ch21 = new TreeNodeImpl(14);
        TreeNodeImpl ch211 = new TreeNodeImpl(13);
        root.setRight(ch2);
        root.setLeft(ch1);
        ch1.setLeft(ch11);
        ch1.setRight(ch12);
        ch12.setRight(ch122);
        ch12.setLeft(ch121);
        ch2.setRight(ch21);
        ch21.setLeft(ch211);
        System.out.println("8\n" +
                "3 10\n" +
                "1-6 14\n" +
                "  4-7 13");
        return root;
    }

    /**
     * There is a binary search tree. It is required to develop a method getMaxDepth(BinaryNode root)
     * which returns the maximum depth of the tree.
     *
     * @param root
     * @return
     */
    public int getMaxDepth(TreeNodeImpl root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getMaxDepth(root.left);
        int rightDepth = getMaxDepth(root.right);
        int maxDepth = Math.max(leftDepth, rightDepth);
        return maxDepth + 1;
    }
}
