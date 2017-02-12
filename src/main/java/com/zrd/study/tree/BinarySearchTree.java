package com.zrd.study.tree;

/**
 * Created by zrd on 2017/2/12.
 */
public class BinarySearchTree<T extends Comparable<T>> {
    private BinaryNode<T> root;

    public void insert(T value){
        if(root == null){
            root = new BinaryNode<T>(value);
        }else{
            insert(root, value);
        }
    }

    private void insert(BinaryNode<T> node, T value){
        assert node != null;
        assert value != null;

        if(node.getValue().compareTo(value) == 0){
            return;
        }else if(node.getValue().compareTo(value) < 0){
            if(node.getLeft() == null){
                node.setLeft(new BinaryNode<T>(value));
            }else{
                this.insert(node.getLeft(), value);
            }
        }else{
            if(node.getRight() == null){
                node.setRight(new BinaryNode<T>(value));
            }else{
                this.insert(node.getRight(), value);
            }
        }
    }

    public void remove(T value){
        assert value != null;
        if(root == null){
            return;
        }

        if(root.getValue().compareTo(value) == 0){
            if(root.getRight() != null){
                BinaryNode<T> rightMin = findMin(root.getRight());

            }
        }else if(node.getValue().compareTo(value) < 0){
            remove(node.getLeft(), value);
        }else{
            remove(node.getRight(), value);
        }
    }

    public void remove(BinaryNode<T> node, T value){
        assert value != null;
        if(node == null){
            return;
        }

        if(node.getValue().compareTo(value) == 0){

        }else if(node.getValue().compareTo(value) < 0){
            remove(node.getLeft(), value);
        }else{
            remove(node.getRight(), value);
        }
    }

    public boolean contains(T value){
        if(root == null){
            return false;
        }else{
            return find(root, value) == null ? false : true;
        }
    }

    private BinaryNode<T> find(BinaryNode<T> node, T value){
        assert value != null;
        if(node == null){
            return null;
        }

        if(node.getValue().compareTo(value) == 0){
            return node;
        }else if(node.getValue().compareTo(value) < 0){
            return find(node.getLeft(), value);
        }else{
            return find(node.getRight(), value);
        }

    }

    public BinaryNode<T> findMin(){
        return findMin(root);
    }

    private BinaryNode<T> findMin(BinaryNode<T> node){
        if(node.getLeft() == null){
            return node;
        }else{
            return findMin(node.getLeft());
        }
    }

    public BinaryNode<T> findMax(){
        return findMax(root);
    }

    private BinaryNode<T> findMax(BinaryNode<T> node){
        if(node.getRight() == null){
            return node;
        }else{
            return findMax(node.getRight());
        }
    }

    public void isEmpty(){

    }

    public void makeEmpty(){

    }

    public void printTree(){

    }
}
