package ElementsofPI.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SAmitabh on 23-08-2016.
 */
public class deleteDups {
       public static void deleteDups(List<Integer> A){

           int currWrite = 0;
           for(int i = 1 ; i< A.size(); i++){
               if(A.get(i) == A.get(i-1)) continue;
               else A.set(++currWrite,A.get(i));
           }

               System.out.println(currWrite);

       }


    public static void main(String[] args){
        List<Integer> A = new ArrayList<>();
        A.add(0);
        A.add(0);
        A.add(0);
        A.add(1);
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(3);
        deleteDups(A);
    }

}
