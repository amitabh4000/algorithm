package ElementsofPI.DP;

/**
 * Created by SAmitabh on 10-11-2016.
 */
public class KnapsackFractional {
    public static int maxProfit(int[] weights, int[] values, int maxWeight){

        int[] table = new int[maxWeight+1];

        for(int i = 0 ; i < weights.length; i++){
            System.out.print(i+ "   ");
            boolean[] isIncluded = new boolean[maxWeight+1];
            for(int j = 0 ; j <= maxWeight; j++){
                int excluded = i == 0 ? 0 : table[j] ;
                int included = (j - weights[i]) >= 0 && !isIncluded[j-weights[i]] ? (table[j-weights[i]] + values[i]): 0;
                if(included > excluded){
                    table[j] = included;
                    isIncluded[j] = true;
                }
                else{
                    table[j] = excluded;
                }
                System.out.print("" + table[j]+" ");
            }
            System.out.println();
        }
       return table[maxWeight];
    }


    public static void main(String[] args){

        int[] weights = {2,4,5,6,7};
        int[] values = {10,10,12,15,17};
        int max = 11;
        System.out.println(maxProfit(weights,values,max));
    }

}
