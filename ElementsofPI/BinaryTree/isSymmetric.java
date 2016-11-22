package ElementsofPI.BinaryTree;

/**
 * Created by SAmitabh on 01-09-2016.
 */
public class isSymmetric {

    public static boolean isSymmetric(TreeNode<Integer> tree) {

        return tree == null || checkSymmetric(tree.left, tree.right);
    }

    public static boolean checkSymmetric(TreeNode<Integer> left, TreeNode<Integer> right) {

        if (left == null && right == null) return true;
        if (left == null ^ right == null) return false;
        return (left.data == right.data &&
                checkSymmetric(left.left, right.right) &&
                checkSymmetric(left.right, right.left));


    }
}
