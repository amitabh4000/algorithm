package ElementsofPI.BST;

import java.util.*;


public class ReConstructBST {




    //////////
    public BSTNode<Integer> ReConstruct1(List<Integer> list){

     return  helper1(list , 0 , list.size());
    }
     public BSTNode<Integer> helper1(List<Integer> list , int beg , int end){

        BSTNode<Integer> root = new BSTNode<>(list.get(beg),null,null);

        if(beg >= end) return null;


        int iter = beg+1;
        while(iter < end && list.get(beg) > list.get(iter)){
            iter++;
        }
        return new BSTNode<>(list.get(beg),helper1(list, beg + 1, iter),helper1(list,iter,end));

    }

//////////////////////// O(n) /////////////////////////
    public int idx = 0;
    public BSTNode<Integer> ReConstruct2(List<Integer> list){

        return  helper2(list, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public BSTNode<Integer> helper2(List<Integer> list , int lower , int upper){

        if(idx == list.size()) {
            return null;
        }
        int rootVal = list.get(idx);
        if(rootVal<lower || rootVal > upper) {
            return null;
        }
        idx++;

        BSTNode<Integer> left = helper2(list , lower , rootVal);
        BSTNode<Integer> right = helper2(list, rootVal, upper);
        return new BSTNode<>(rootVal , left, right);
    }

}
