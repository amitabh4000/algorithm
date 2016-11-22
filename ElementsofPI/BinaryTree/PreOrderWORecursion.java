package ElementsofPI.BinaryTree;

import java.util.*;

/**
 * Created by SAmitabh on 07-09-2016.
 */
public class PreOrderWORecursion {


    public static void PreOrderWORecursion(TreeNode <Integer> root){

        Stack <TreeNode <Integer>> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        stack.push(root);
        while(!stack.empty()){
            TreeNode<Integer> temp = stack.pop();
            if(temp != null) {
                list.add(temp.data);
                stack.push(temp.left);
                stack.push(temp.right);
            }
        }
    }
}
