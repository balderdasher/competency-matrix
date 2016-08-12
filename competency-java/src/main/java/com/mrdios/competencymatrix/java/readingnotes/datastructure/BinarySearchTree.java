package com.mrdios.competencymatrix.java.readingnotes.datastructure;

import java.util.TreeSet;

/**
 * @author mrdios
 * @date 2016-08-07 14:01
 */
public class BinarySearchTree<T> {

    private TreeNode<T> root;

    public TreeNode<T> get(T t) {
        TreeNode<T> pNode = root;

        while (pNode != null && pNode.data.hashCode() != t.hashCode()) {
            if (t.hashCode() < pNode.data.hashCode()) {
                pNode = pNode.leftNode;
            } else {
                pNode = pNode.rightNode;
            }
        }
        return pNode;
    }

    public class TreeNode<T> {
        T data;
        TreeNode leftNode;
        TreeNode rightNode;

        public TreeNode(T data, TreeNode leftNode, TreeNode rightNode) {
            this.data = data;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }

    }
}
