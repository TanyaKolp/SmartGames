package com.tania;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by tania on 7/14/16.
 */
public class TreeNodeImpl {
    int val;
    TreeNodeImpl left = null;
    TreeNodeImpl right = null;


    public TreeNodeImpl(int val) {
        this.val = val;
    }

    public TreeNodeImpl getLeft() {
        return left;
    }

    public void setLeft(TreeNodeImpl left) {
        this.left = left;
    }

    public TreeNodeImpl getRight() {
        return right;
    }

    public void setRight(TreeNodeImpl right) {
        this.right = right;
    }
}
