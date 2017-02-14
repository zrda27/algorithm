package com.zrd.study.tree;

/**
 * 平衡二叉树
 * @author zrd
 *
 */
public class AVLTree<T extends Comparable<T>> {
	private static class AvlNode<T> {
		AvlNode<T> left;
		AvlNode<T> right;
		T data;
		int height;
		
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
	
	public void remove(T data){
		root = remove(root, data);
	}
	
	private AvlNode<T> remove(AvlNode<T> node, T data){
		if(node == null){
			return null;
		}
		int cmpResult = data.compareTo(node.data);
		if(cmpResult < 0){
			node.left = remove(node.left, data);
			if(getHeight(node.right) - getHeight(node.left) == 2){
				if(node.right.right == null){
					node.right = rotateWithLeftChild(node.right);
				}
				node = rotateWithRightChild(node);
			}
		}else if(cmpResult > 0){
			node.right = remove(node.right, data);
			if(getHeight(node.left) - getHeight(node.right) == 2){
				if(node.left.left == null){
					node.left = rotateWithRightChild(node.left);
				}
				node = rotateWithLeftChild(node);
			}
		}else{
			if(node.right != null && node.left != null){
				AvlNode<T> minRightSubNode = findMin(node.right);
        		node.data = minRightSubNode.data;
        		node.right = remove(node.right, minRightSubNode.data);
        	}else{
        		node = node.right == null ? node.left : node.right;
        	}
		}
		return node;
	}
	
	private AvlNode<T> findMin(AvlNode<T> node){
		if(node.left != null){
			return findMin(node.left);
		}else{
			return node;
		}
	}
	
	public void printTree(){
    	printTree(root);
    	System.out.println("");
    }
    
    private void printTree(AvlNode<T> node){
    	if(node == null){
    		return;
    	}
    	printTree(node.left);
    	System.out.print(node.data + "  ");
    	printTree(node.right);
    }
    
    public boolean isEmpty(){
    	return root == null;
    }
}
