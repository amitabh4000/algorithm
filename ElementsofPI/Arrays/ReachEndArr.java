package ElementsofPI.Arrays;
import java.util.*;


/**
 * Created by SAmitabh on 23-08-2016.
 */
public class ReachEndArr {

    public static boolean canReach( List<Integer> maxAdvance){


        int farthest = 0;
        for(int i = 0 ; i < maxAdvance.size(); i++){
            if(farthest < i) return false;
            farthest = Math.max(farthest ,i + maxAdvance.get(i));
        }
        return true;
    }

    public static int minToReach( List<Integer> maxAdvance){

        List<Integer> DP = new ArrayList<>(Collections.nCopies(maxAdvance.size() , maxAdvance.size()));
        DP.set(0,0);
        int farthest = 0;
        for(int i = 0 ; i< maxAdvance.size(); i++){
            int step = maxAdvance.get(i);
            int istep = DP.get(i);
            for(int j = i ; j <= i+step && j < maxAdvance.size(); j++ ){
                DP.set( j , Math.min(DP.get(j) ,istep+1));
            }

        }
        return DP.get(DP.size()-1);
    }
    public static void main(String[] args){
        List<Integer> A = new ArrayList<>();
        A.add(3);
        A.add(3);
        A.add(1);
        A.add(0);
        A.add(2);
        A.add(0);
        A.add(1);
        System.out.println(canReach(A));
        System.out.println(minToReach(A));
    }
}
