package test.com.zrd.study.tree;

import com.zrd.study.tree.RBTree;

/**
 * Created by zrd on 2017/2/15.
 */
public class RBTreeTest {
    public static void main(String[] args) {
        RBTree<Integer> intTree = new RBTree<>();

        System.out.println(intTree.isEmpty());
        intTree.insert(3);
        intTree.printTree();
        intTree.insert(2);
        intTree.printTree();
        intTree.insert(5);
        intTree.printTree();
        intTree.insert(21);
        intTree.printTree();
        intTree.insert(22);
        intTree.printTree();
        intTree.insert(23);
        intTree.printTree();
        intTree.insert(24);
        intTree.printTree();
        intTree.insert(25);
        intTree.printTree();
        System.out.println(intTree.isEmpty());
    }
}
