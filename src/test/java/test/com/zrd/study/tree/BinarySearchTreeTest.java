package test.com.zrd.study.tree;

import com.zrd.study.tree.BinarySearchTree;

/**
 * Created by zrd on 2017/2/12.
 */
public class BinarySearchTreeTest {
    public static void main(String[] args) {
        BinarySearchTree<Integer> intTree = new BinarySearchTree<>();
        
        System.out.println(intTree.isEmpty());
        intTree.insert(3);
        intTree.printTree();
        intTree.insert(2);
        intTree.printTree();
        intTree.insert(5);
        intTree.printTree();
        intTree.remove(21);
        intTree.printTree();
        intTree.insert(21);
        intTree.printTree();
        intTree.remove(3);
        intTree.printTree();
        System.out.println(intTree.isEmpty());
    }
}
