package randomSnippets;

import java.util.*;

public class Array_vs_ArrayList {


    public static void test(){
        int[] arr = new int[1000000];
        List<Integer> list = new ArrayList<>(1000000);

        long starttime = System.currentTimeMillis();


        //for(int j = 0 ; j< 100; j++)
        for(int i = 0 ; i< arr.length; i++){
            arr[i] = i;
        }
        System.out.println("Time taken by array is: "+(System.currentTimeMillis()-starttime));

        long starttime1 = System.currentTimeMillis();

        //for(int j = 0 ; j< 100; j++)
        for(int i = 0 ; i< 1000000; i++){
            list.add(i);
        }
        System.out.println("Time taken by arrayList is: "+(System.currentTimeMillis()-starttime1));
    }

    public static void main(String[] args){
        test();
    }
}
