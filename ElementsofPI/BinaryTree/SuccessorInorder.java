package ElementsofPI.BinaryTree;

/**
 * Created by SAmitabh on 07-09-2016.
 */
public class SuccessorInorder {

    public static TreeNodeP<Integer> successorInorder(TreeNodeP<Integer> node){

        if(node.right == null){
            while(node.parent != null && node.parent.right==node){
                node = node.parent;
            }
            return node;
        }
        else{
            TreeNodeP<Integer> right = node.right;
            while(node.left != null){
                right = right.left;
            }
            return right;
        }

    }

}
