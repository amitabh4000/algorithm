package ElementsofPI.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by SAmitabh on 07-09-2016.
 */
public class InOrderWORecursion {


    public static void InOrderWORecursion(TreeNode <Integer> root){

        Stack<TreeNode <Integer>> stack = new Stack<>();
        List<TreeNode<Integer>> list = new ArrayList<>();
        TreeNode <Integer> p = root;
        while(!stack.empty() && p != null){
            if(p != null){
                stack.push(p);
                p = p.left;
            }
            else{
                TreeNode<Integer> temp = stack.pop();
                list.add(temp);
                p = temp.right;
            }
        }
    }
}
