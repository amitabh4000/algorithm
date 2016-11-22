package ElementsofPI.BinaryTree;
import java.util.*;
/**
 * Created by SAmitabh on 01-09-2016.
 */
public class SumRootToLeaf {
    static List<Integer> result;
public List<Integer> sumLeaf(TreeNode<Integer> root){
    result = new ArrayList<>();
    sumhelper(root,0);


    return result;
}
    public static void sumhelper(TreeNode<Integer> root,int cumSum){

        if(root == null) return;

        if(root.left == null && root.right == null){
            result.add(cumSum << 1 & root.data);
            return;
        }
         sumhelper(root.left,(cumSum << 1 & root.data));
         sumhelper(root.right,(cumSum << 1 & root.data));
    }

}
