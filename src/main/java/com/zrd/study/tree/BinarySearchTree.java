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

        if(node.data.compareTo(value) == 0){
            return;
        }else if(node.data.compareTo(value) > 0){
            if(node.left == null){
                node.left = new BinaryNode<T>(value);
            }else{
                this.insert(node.left, value);
            }
        }else{
            if(node.right == null){
                node.right = new BinaryNode<T>(value);
            }else{
                this.insert(node.right, value);
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

        if(node.data.compareTo(value) == 0){
        	if(node.right != null && node.left != null){
        		BinaryNode<T> minRightSubNode = findMin(node.right);
        		node.data = minRightSubNode.data;
        		node.right = remove(node.right, minRightSubNode.data);
        	}else{
        		node = node.right == null ? node.left : node.right;
        	}
        }else if(node.data.compareTo(value) > 0){
        	node.left = remove(node.left, value);
        }else{
        	node.right = remove(node.right, value);
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

        if(node.data.compareTo(value) == 0){
            return node;
        }else if(node.data.compareTo(value) > 0){
            return find(node.left, value);
        }else{
            return find(node.right, value);
        }

    }

    public BinaryNode<T> findMin(){
        return findMin(root);
    }

    private BinaryNode<T> findMin(BinaryNode<T> node){
        if(node.left == null){
            return node;
        }else{
            return findMin(node.left);
        }
    }

    public BinaryNode<T> findMax(){
        return findMax(root);
    }

    private BinaryNode<T> findMax(BinaryNode<T> node){
        if(node.right == null){
            return node;
        }else{
            return findMax(node.right);
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
    	printTree(node.left);
    	System.out.print(node.data + "  ");
    	printTree(node.right);
    }

    protected BinaryNode<T> rotateWithLeftChild(BinaryNode<T> node){
        BinaryNode<T> tmp = node.left;
        node.left = tmp.right;
        tmp.right = node;
        return tmp;
    }

    protected BinaryNode<T> rotateWithRightChild(BinaryNode<T> node){
        BinaryNode<T> tmp = node.right;
        node.right = tmp.left;
        tmp.left = node;
        return tmp;
    }
}
