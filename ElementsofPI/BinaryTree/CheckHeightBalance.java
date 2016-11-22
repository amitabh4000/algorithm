package ElementsofPI.BinaryTree;

/**
 * Created by SAmitabh on 01-09-2016.
 */
public class CheckHeightBalance {

    private static class BalanceStatusWithheight {
        public boolean balanced;
        public int height;

        public BalanceStatusWithheight (boolean balanced , int height){
            this.balanced = balanced;
            this.height = height;
        }
    }

    public static boolean isBalanced(TreeNode<Integer> tree){
        return checkBalanced(tree).balanced;
    }
    private static BalanceStatusWithheight checkBalanced( TreeNode<Integer> tree){
        if(tree == null){
            return new BalanceStatusWithheight(true , -1);
        }
        BalanceStatusWithheight leftResult = checkBalanced(tree.left);
        if(! leftResult.balanced){
            return leftResult;
        }
        BalanceStatusWithheight rightResult = checkBalanced(tree.right);
        if(! rightResult.balanced){
            return rightResult;
        }
        boolean isBalanced = Math.abs(leftResult.height - rightResult.height) <= 1 ;
        int height = Math.max( leftResult.height ,rightResult.height) + 1;
        return new BalanceStatusWithheight(isBalanced , height);
    }
}
