package ElementsofPI.Arrays;

import java.util.*;
/**
 * Created by SAmitabh on 23-08-2016.
 */
public class multiplyInt {
    public static void mult(String s1 , String s2){
        int carry = 0;
        List<Integer> list = new ArrayList<>(Collections.nCopies(s1.length()+s2.length() ,0));
        int l1 = s1.length()-1;
        int l2 = s2.length()-1;
        for(int i = l1; i >= 0 ; i--){
            for(int j = l2 ; j >=0 ; j--){
                int c1 = s1.charAt(i)- '0';
                int c2 = s2.charAt(j)- '0';
                int num = list.get(i+j+1) + c1*c2;
               // list.set(i+j+1 , list.get(i+j+1)+c1*c2);
                list.set(i+j , list.get(i+j)+num/10 );
                list.set(i+j+1 , num%10 );
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < list.size(); i++){
            if(list.get(i) == 0) continue;
            sb.append(list.get(i));
        }
        System.out.println(sb.toString());
    }
    public static void main(String[] args){
        mult("787888878","98776646464646466446");
    }

}
