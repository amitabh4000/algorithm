package ElementsofPI.Arrays;

import java.util.*;


/**
 * Created by SAmitabh on 23-08-2016.
 */
public class increaseByOne {

    public static void arrange(List<Integer> A) {

        int carry = 1;
        int i = A.size()- 1 ;
        while( i >= 0){
            A.set(i , (A.get(i)+carry)%10);
            carry = (A.get(i)+carry)/10;
          }
        if(A.get(0)==10){
            A.set(0,0);
            A.add(0,1);
        }
    }

    public static void main(String[] args) {
        List<Integer> A = new LinkedList<>();
        A.add(9);
        A.add(9);
        A.add(3);
        A.add(6);
        A.add(6);
        A.add(9);
        A.add(3);
        A.add(9);
        arrange(A);
    }
}
