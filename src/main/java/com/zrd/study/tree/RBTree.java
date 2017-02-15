package com.zrd.study.tree;

public class RBTree<T extends Comparable<T>> {
	private static class RBNode<T>{
		RBNode<T> left;
		RBNode<T> right;
		T data;
		byte color; //0为黑色，1为红色
		
		public RBNode(T data){
			this.data = data;
		}
		
		public RBNode(T data, RBNode<T> left, RBNode<T> right, byte color){
			this.data = data;
			this.left = left;
			this.right = right;
			this.color = color;
		}
	}
	
	private void insert(RBNode<T> node, T data){
		
	}
}
