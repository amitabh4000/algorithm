package ElementsofPI.BinaryTree;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * Created by SAmitabh on 07-09-2016.
 */
public class InorderWithConstantSpace {

    public static void InOrderWORecursion(TreeNodeP<Integer> root){

        List<TreeNodeP<Integer>> list = new ArrayList<>();
        TreeNodeP<Integer> p = root;
        TreeNodeP<Integer> prev = null, curr= root;

        while( curr != null){
            TreeNodeP<Integer> next = null;
            if(prev == curr.parent){
                if(null != curr.left){
                    next = curr.left;
                }
                else{
                    list.add(curr);
                    next = null != curr.right ? curr.right : curr.parent;
                }
                if(prev == curr.left){
                    list.add(curr);
                    next = null != curr.right ? curr.right : curr.parent;
                }
                else{
                    next = curr.parent;
                }
            }
            curr = next;
            prev = curr;
        }
    }

}
