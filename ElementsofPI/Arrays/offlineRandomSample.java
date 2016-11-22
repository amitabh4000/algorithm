package ElementsofPI.Arrays;

import java.util.*;

/**
 * Created by SAmitabh on 30-08-2016.
 */
public class offlineRandomSample {

    public static void offlineRandomSample (int k , List<Integer> A){
        Random gen = new Random();
        for(int i = 0 ; i < k ; i++){
            Collections.swap(A , i , i + gen.nextInt(A.size()-1));
        }
    }


    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(3);
        A.add(2);
        A.add(4);
        A.add(12);
        A.add(8);
        A.add(5);
        A.add(9);
        A.add(10);
        offlineRandomSample(3, A);
    }
}
