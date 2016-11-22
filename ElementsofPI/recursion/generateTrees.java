package ElementsofPI.recursion;

import java.util.*;

public class generateTrees {

    public static class TreeNode <T>{
        T val;
        TreeNode<T> left;
        TreeNode<T> right;
        public TreeNode(T val,TreeNode<T> left,TreeNode<T> right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<TreeNode<Integer>> genTrees(int numNodes){

        List<TreeNode<Integer>> res = new ArrayList<>();
        if(numNodes == 0){
            res.add(null);
            return res;
        }
        for(int leftNum = 0 ; leftNum <= numNodes; leftNum++){

            int rightNum = numNodes - leftNum -1;
            List<TreeNode<Integer>> leftRes = genTrees(leftNum);
            List<TreeNode<Integer>> rightRes = genTrees(rightNum);
            for(TreeNode<Integer> left:leftRes){
                for(TreeNode<Integer> right:rightRes){
                    res.add(new TreeNode(0,left,right));
                }
            }   //// End inner double for
        }     //// End outer for loop

        return res;
    }
}
