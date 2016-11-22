package ElementsofPI.BST;

import java.util.*;
public class minHeightBSTSortedArray {

    public BSTNode<Integer> BSTFromArray(List<Integer> list){
        int length = list.size();
       return helper(list ,0,list.size()-1);
    }

    public BSTNode<Integer> helper(List<Integer> list , int beg , int end){

        if(beg < end){
            return null;
        }
        int mid = (beg+end)/2;
        BSTNode<Integer> root = new BSTNode<>(list.get(mid),
                                              helper(list ,beg,mid-1 ),
                                              helper(list,mid+1,end));
        return root;
    }

}
