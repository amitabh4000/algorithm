package ElementsofPI.Arrays;

import java.util.*;

/**
 * Created by SAmitabh on 30-08-2016.
 */
public class onlineRAndomSample {
   public static List<Integer> onlineRAndomSample (int k , Iterator<Integer> A){
       List<Integer> runningStream = new ArrayList<>();
       for(int i = 0 ; i < k && A.hasNext(); i++){
           runningStream.add(A.next());
       }
       int countTillNow = k;
       Random randIdxGen = new Random();
       while(A.hasNext()){
         int x = A.next();
         ++countTillNow;
           int idxToReplace = randIdxGen.nextInt(countTillNow);
           if(idxToReplace < k){
               runningStream.set(idxToReplace , x);
           }
       }
       return  runningStream;
   }


    public static void main(String[] args) {
        List<Integer> A = new LinkedList<>();
        A.add(3);
        A.add(2);
        A.add(4);
        A.add(12);
        A.add(8);
        A.add(5);
        A.add(9);
        A.add(10);
        onlineRAndomSample(3,A.iterator());
    }
}
