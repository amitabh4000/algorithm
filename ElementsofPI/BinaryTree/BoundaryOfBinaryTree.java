package ElementsofPI.BinaryTree;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by SAmitabh on 09-09-2016.
 */
public class BoundaryOfBinaryTree {

    public static List<TreeNode<Integer>> list;
    public static List<TreeNode<Integer>> BoundaryOfBinaryTree(TreeNode <Integer> root){

        list = new LinkedList<>();
        list.add(root);
        list.addAll(addNodesLeft(root.left,true));
        list.addAll(addNodesRight(root.right,true));

        return list;
    }

    public static List<TreeNode<Integer>> addNodesLeft(TreeNode<Integer> root ,boolean isBoundary){

        List <TreeNode<Integer>> list = new LinkedList<>();
        if( root != null) {
            if (isBoundary || isLeaf(root)) {
                list.add(root);
            }
            list.addAll(addNodesLeft(root.left, isBoundary));
            list.addAll(addNodesLeft(root.right, isBoundary && root.left == null));
        }
        return list;
        }


    public static List<TreeNode<Integer>> addNodesRight(TreeNode<Integer> root , boolean isBoundary){

        List <TreeNode<Integer>> list = new LinkedList<>();
        if( root != null){
            list.addAll(addNodesRight(root.left, isBoundary && root.right == null));
            list.addAll(addNodesRight(root.right, isBoundary));
            if(isBoundary || isLeaf(root)){
              list.add(root);
            }
        }
    return list;
    }
    public static boolean isLeaf(TreeNode<Integer> root){
        return root.left == null && root.right == null;
    }
}

