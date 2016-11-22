package ElementsofPI.BinaryTree;

/**
 * Created by SAmitabh on 15-09-2016.
 */
public class RightSiblingTree {

    public static void addRightSibling1(TreeNodeR<Integer> root){

        helper(root.left, root.right);
    }
    public static void helper(TreeNodeR<Integer> left, TreeNodeR<Integer> right){
        if(left == null) return;
        left.rightSib = right;
        left.left.rightSib = left.right;
        left.right.rightSib = right.left;
        right.left.rightSib = right.right;
        helper(left.left , left.right);
        helper(left.right , right.left);
        helper(right.left , right.right);
    }
    public static void addRightSibling2(TreeNodeR<Integer> root){

        TreeNodeR <Integer> start= root;
        while(start!= null && start.left != null){
            helper2(start);
            start = start.left;
        }
    }
    public static void helper2(TreeNodeR<Integer> root){

        TreeNodeR <Integer> iter = root;
        while(iter != null){
            iter.left.rightSib = iter.right;
            if(iter.rightSib != null){
                iter.right.rightSib = iter.rightSib.left;
            }
            iter = iter.rightSib;
        }
    }
}
