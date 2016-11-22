package ElementsofPI.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by SAmitabh on 27-08-2016.
 */
public class nextPerm {

    public static void  nextPerm(List<Integer> A){

        int length = A.size();
        int res = 0;
        int k = length -1;
        while( k > 0 && A.get(k) < A.get(k-1)) k--;
        if(k == 0) return ;
        int min = Integer.MAX_VALUE;
        int ind = 0;
        for(int i = A.size() ; i >= k;i-- ){
            if(A.get(i) > A.get(k-1)){
                Collections.swap(A, i, k-1);
            }
        }
        Collections.reverse(A.subList(k, length));
       for(Integer nums:A){
           System.out.println(nums+" ,");
       }

    }
    public static void main(String[] args) {
        List<Integer> A = new LinkedList<>();
        A.add(2);
        A.add(5);
        A.add(3);
        A.add(8);
        A.add(5);
        A.add(3);
        A.add(2);
        A.add(0);
        nextPerm(A);
    }
}
