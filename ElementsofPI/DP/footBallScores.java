package ElementsofPI.DP;

import java.util.*;
import java.util.stream.*;

public class footBallScores {

//    private static final int TOUCHDOWN = 7;
//    private static final int SAFETY = 2;
//    private static  final int FIELDGOAL = 3;

    public static int ways(List<Integer> scores,int n){

        List<List<Integer>> cache = new ArrayList<>();
        for(int i = 0 ; i < scores.size(); i++){
            List<Integer> temp = new ArrayList<>(Collections.nCopies(n+1,0));
            temp.set(0,1);
            cache.add(temp);
        }

        for(int i = 0 ; i < scores.size(); i++){
            for(int j = 1; j <= n ; j++) {
                int sum = 0;

                if((j-scores.get(i)) >= 0) sum += cache.get(i).get(j - scores.get(i));
                if (i > 0) sum += cache.get(i - 1).get(j);

                cache.get(i).set(j ,sum);
            }
        }
        return cache.get(cache.size()-1).get(cache.get(0).size()-1);
    }

    public static void main(String[] args){
        int[] arr = {2,3,7};
        System.out.println(ways(Arrays.stream(arr).boxed().collect(Collectors.toList()),12) );

    }

}
