package test.com.zrd.study.tree;

import com.zrd.study.tree.BinarySearchTree;

/**
 * Created by zrd on 2017/2/12.
 */
public class BinarySearchTreeTest {
    public static void main(String[] args) {
        BinarySearchTree<Integer> intTree = new BinarySearchTree<>();

        intTree.insert(3);
        intTree.insert(2);
        intTree.insert(5);

        System.out.println(intTree.contains(2));
        System.out.println(intTree.contains(67));
    }
}
