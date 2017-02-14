package test.com.zrd.study.tree;

import com.zrd.study.tree.AVLTree;

public class AvlTreeTest {
	public static void main(String[] args) {
		AVLTree<Integer> intTree = new AVLTree<>();
        
        System.out.println(intTree.isEmpty());
        intTree.insert(2);
        intTree.printTree();
        intTree.insert(1);
        intTree.printTree();
        intTree.insert(4);
        intTree.printTree();
        intTree.insert(3);
        intTree.printTree();
        intTree.remove(2);
        intTree.printTree();
        intTree.insert(21);
        intTree.printTree();
        intTree.remove(3);
        intTree.printTree();
        System.out.println(intTree.isEmpty());
	}
}
