package com.zrd.study.tree;

/**
 * 平衡二叉树
 * @author zrd
 *
 */
public class AVLTree<T extends Comparable<T>> {
	private static class AvlNode<T>{
		AvlNode<T> left;
		AvlNode<T> right;
		T data;
		int height;
		AvlNode(T data){
			this.data = data;
		}
		AvlNode(T data, AvlNode<T> left, AvlNode<T> right){
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	private int getHeight(AvlNode<T> node){
		return node == null ? -1 : node.height;
	}

	AvlNode<T> root;

	public void insert(T data){
		root = insert(root, data);
	}

	private AvlNode<T> insert(AvlNode<T> node, T data){
		if(node == null){
			return new AvlNode<>(data, null, null);
		}
		int compareResult = data.compareTo(node.data);

		if(compareResult < 0){
			node.left = insert(node.left, data);
			if(getHeight(node.left) - getHeight(node.right) == 2){
				if(data.compareTo(node.left.data) > 0){
					node.left = rotateWithRightChild(node.left);
				}
				node = rotateWithLeftChild(node);
			}
		}else if(compareResult > 0){
			node.right = insert(node.right, data);
			if(getHeight(node.right) - getHeight(node.left) == 2){
				if(data.compareTo(node.right.data) < 0){
					node.right = rotateWithLeftChild(node.right);
				}
				node = rotateWithRightChild(node);
			}
		}
		node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
		return node;
	}

	private AvlNode<T> rotateWithLeftChild(AvlNode<T> node){
		AvlNode<T> tmp = node.left;
		node.left = tmp.right;
		tmp.right = node;
		node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
		tmp.height = Math.max(getHeight(tmp.left), getHeight(tmp.right)) + 1;
		return tmp;
	}

	private AvlNode<T> rotateWithRightChild(AvlNode<T> node){
		AvlNode<T> tmp = node.right;
		node.right = tmp.left;
		tmp.left = node;
		node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
		tmp.height = Math.max(getHeight(tmp.left), getHeight(tmp.right)) + 1;
		return tmp;
	}
}
