package com.zrd.study.tree;

/**
 * Created by zrd on 2017/2/12.
 */
public class BinaryNode<T> {
    private BinaryNode<T> left;
    private BinaryNode<T> right;
    private T value;
    BinaryNode(T value){
        this.value = value;
    }
    BinaryNode(T value, BinaryNode<T> left, BinaryNode<T> right){
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public BinaryNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryNode<T> left) {
        this.left = left;
    }

    public BinaryNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryNode<T> right) {
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
