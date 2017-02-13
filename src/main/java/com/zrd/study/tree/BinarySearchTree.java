package com.zrd.study.tree;

/**
 * 二叉查找树
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
        }else if(node.getValue().compareTo(value) > 0){
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
    	root = remove(root, value);
    }

    public BinaryNode<T> remove(BinaryNode<T> node, T value){
        assert value != null;
        if(node == null){
            return null;
        }

        if(node.getValue().compareTo(value) == 0){
        	if(node.getRight() != null && node.getLeft() != null){
        		BinaryNode<T> minRightSubNode = findMin(node.getRight());
        		node.setValue(minRightSubNode.getValue());
        		node.setRight(remove(node.getRight(), minRightSubNode.getValue()));
        	}else{
        		node = node.getRight() == null ? node.getLeft() : node.getRight();
        	}
        }else if(node.getValue().compareTo(value) > 0){
        	node.setLeft(remove(node.getLeft(), value));
        }else{
        	node.setRight(remove(node.getRight(), value));
        }
        return node;
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
        }else if(node.getValue().compareTo(value) > 0){
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

    public boolean isEmpty(){
    	return root == null;
    }

    public void makeEmpty(){
    	root = null;
    }

    public void printTree(){
    	printTree(root);
    	System.out.println("");
    }
    
    private void printTree(BinaryNode<T> node){
    	if(node == null){
    		return;
    	}
    	printTree(node.getLeft());
    	System.out.print(node.getValue() + "  ");
    	printTree(node.getRight());
    }
}
