package com.zrd.study.tree;

public class RBTree<T extends Comparable<T>>{
	RBNode<T> root;
	private static class RBNode<T>{
		RBNode<T> left;
		RBNode<T> right;
		T data;
		int color = 1; //1为黑色，0为红色
		
		public RBNode(T data, RBNode<T> left, RBNode<T> right, int color){
			this.data = data;
			this.left = left;
			this.right = right;
			this.color = color;
		}
	}

	public void insert(T data){
		insert(root, null, data);
	}
	
	private RBNode<T> insert(RBNode<T> node, RBNode<T> parentNode, T data){
		if(node == null){
			root = new RBNode<T>(data, null, null, 1);
			return null;
		}
		boolean isRoot = parentNode == root;
		boolean isLeft = parentNode != null && parentNode.left == node;
		int cmpResult = data.compareTo(node.data);
		if(cmpResult < 0){
			if(node.left == null){
				node.left = new RBNode<T>(data, null, null, 0);
			}else{
				if(node != root){
					if(isLeft){
						parentNode.left = insert(node.left, node, data);
					}else{
						parentNode.right = insert(node.left, node, data);
					}
				}else{
					node = insert(node.left, node, data);
				}
			}
			if(node.left.color == 0 && node.color == 0){//插入点的父节点为红色
				if(isLeft){
					if(parentNode.right != null && parentNode.right.color == 0){//父节点的兄弟节点为红色
						parentNode.color = 0;
						parentNode.left.color = 1;
						parentNode.right.color = 1;
					}else{
						parentNode = (RBNode<T>)this.rotateWithLeftChild(parentNode);
						parentNode.color = 1;
						parentNode.right.color = 0;
					}
				}else{
					if(parentNode.left != null && parentNode.left.color == 0){//父节点的兄弟节点为红色
						parentNode.color = 0;
						parentNode.right.color = 1;
						parentNode.left.color = 1;
					}else{
						parentNode.right = (RBNode<T>)this.rotateWithLeftChild(node);
						parentNode = (RBNode<T>)this.rotateWithRightChild(parentNode);
						parentNode.color = 1;
						parentNode.left.color = 0;
					}
				}
			}
		}else if(cmpResult > 0){
			if(node.right == null){
				node.right = new RBNode<T>(data, null, null, 0);
			}else{
				if(node != root){
					if(isLeft){
						parentNode.left = insert(node.right, node, data);
					}else{
						parentNode.right = insert(node.right, node, data);
					}
				}else{
					node = insert(node.right, node, data);
				}
			}
			if(node.right.color == 0 && node.color == 0){//插入点的父节点为红色
				if(!isLeft){
					if(parentNode.left != null && parentNode.left.color == 0){//父节点的兄弟节点为红色
						parentNode.color = 0;
						parentNode.right.color = 1;
						parentNode.left.color = 1;
					}else{
						parentNode = (RBNode<T>)this.rotateWithRightChild(parentNode);
						parentNode.color = 1;
						parentNode.left.color = 0;
					}
				}else if(node == parentNode.left){
					if(parentNode.right != null && parentNode.right.color == 0){//父节点的兄弟节点为红色
						parentNode.color = 0;
						parentNode.left.color = 1;
						parentNode.right.color = 1;
					}else{
						parentNode.left = (RBNode<T>)this.rotateWithRightChild(node);
						parentNode = (RBNode<T>)this.rotateWithLeftChild(parentNode);
						parentNode.color = 1;
						parentNode.right.color = 0;
					}
				}
			}
		}
		if(isRoot){
			root = parentNode;
			root.color = 1;

		}
		return parentNode;
	}

	protected RBNode<T> rotateWithLeftChild(RBNode<T> node){
		RBNode<T> tmp = node.left;
		node.left = tmp.right;
		tmp.right = node;
		return tmp;
	}

	protected RBNode<T> rotateWithRightChild(RBNode<T> node){
		RBNode<T> tmp = node.right;
		node.right = tmp.left;
		tmp.left = node;
		return tmp;
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

	private void printTree(RBNode<T> node){
		if(node == null){
			return;
		}
		printTree(node.left);
		System.out.print(node.data + "  ");
		printTree(node.right);
	}
}
