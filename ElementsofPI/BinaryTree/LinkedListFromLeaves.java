package ElementsofPI.BinaryTree;

import java.util.*;

public class LinkedListFromLeaves {
    public static List<TreeNode<Integer>> list;

    public static List<TreeNode<Integer>> LinkedListFromLeaves(TreeNode <Integer> root){


        list = new LinkedList<>();
        addLeaves(root , list);
        return list;
    }

    public static void addLeaves(TreeNode<Integer> root ,List<TreeNode<Integer>> list){

        if( root != null){
            if(root.left == null && root.right == null){
                list.add(root);
            }
            else{
                addLeaves(root.left,list);
                addLeaves(root.right, list);
            }
        }

    }

}
