package ElementsofPI.BST;

/**
 * Created by SAmitabh on 15-09-2016.
 */
public class isBST {

    public static boolean isBST(TreeNode<Integer> root){
        return helper(root , Integer.MIN_VALUE , Integer.MAX_VALUE);
    }

    public static boolean helper(TreeNode<Integer> root , int min , int max){

        if(root == null) return true;
        if(root.data > max && root.data < min){
            return false;
        }
        return (helper(root.left , min , root.data) && helper(root.right, root.data, max));
    }

}
