package ElementsofPI.BST;

import java.util.*;
public class KLargestElems {

    public List<BSTNode<Integer>> KLargestElems(BSTNode<Integer> root , int k ){

        List<BSTNode<Integer>> list = new ArrayList<>();
        BSTNode<Integer> iter = root;

        Stack<BSTNode<Integer>> stack = new Stack<>();

        while(! stack.empty()|| iter != null){
            if(iter != null){
                stack.push(iter);
                iter = iter.right;
            }
            else{
                BSTNode<Integer> temp = stack.pop();
                if(list.size() < k)
                list.add(temp);
                else{
                    return list;
                }
                iter = iter.left;
            }
        }
        return list;
    }
}
