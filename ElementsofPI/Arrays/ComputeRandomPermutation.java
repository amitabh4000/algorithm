package ElementsofPI.Arrays;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by SAmitabh on 30-08-2016.
 */
public class ComputeRandomPermutation {

    public static List<Integer> computeRandomPerm(int n){
        List<Integer> permutation = new ArrayList<>(n);
        for(int i = 0 ; i < n; i++){
            permutation.add(i);
        }
        offlineRandomSample.offlineRandomSample(permutation.size() , permutation);
        return permutation;
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
        computeRandomPerm(7);
    }
}
