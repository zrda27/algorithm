package com.zrd.study.tree;

/**
 * Created by zrd on 2017/2/12.
 */
public class BinaryNode<T> {
    BinaryNode<T> left;
    BinaryNode<T> right;
    T data;
    BinaryNode(T data){
        this.data = data;
    }
    BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
