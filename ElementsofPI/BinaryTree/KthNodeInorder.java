package ElementsofPI.BinaryTree;

/**
 * Created by SAmitabh on 07-09-2016.
 */
public class KthNodeInorder {

    public static TreeNodeS<Integer> KthNodeInorder(TreeNodeS<Integer> root, int k){

        if(root.left != null && root.left.size > k){
            KthNodeInorder(root.left, k);
        }
        else if(root.left == null || root.left.size < k+1){
            KthNodeInorder(root.right, k-root.left.size-1);
        }
        else{
            return root;
        }
        return  null;
    }


    public static TreeNodeS<Integer> KthNodeInorderIter(TreeNodeS<Integer> root, int k){

        TreeNodeS<Integer> p =root;

        while(p != null){
            int leftSize = p.left != null ? p.left.size : 0;
            if(leftSize >= k){
                p = p.left;
            }
            else if(leftSize + 1 < k){
                k -= (leftSize+1);
                p = p.right;
            }
            else{
                return p;
            }
        }


        return  null;
    }





}
