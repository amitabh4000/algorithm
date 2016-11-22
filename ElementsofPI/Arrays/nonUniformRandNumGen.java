package ElementsofPI.Arrays;

import java.util.*;
/**
 * Created by SAmitabh on 30-08-2016.
 */
public class nonUniformRandNumGen {
    public static int nonUniformRandNumGen(List<Integer> values , List<Double> prob){

        List<Double> prefixSumProb = new ArrayList<>();
        prefixSumProb.add(0.0);
        for(Double p:prob){
            prefixSumProb.add(prefixSumProb.get(prefixSumProb.size()-1)+ p);
        }
        Random r = new Random();
        Double uniform = r.nextDouble();

        int ind = Collections.binarySearch(prefixSumProb , uniform);
        if(ind < 0 ){
            int modInd = (Math.abs(ind)-1) - 1;
            return values.get(modInd);
        }
        else{
            return values.get(ind);
        }
    }
}
