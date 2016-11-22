package ElementsofPI.DP;

import java.util.*;

public class Stair {


    public static void minWeight(int[][] stair){

        int[] DPArr = new int[stair[stair.length-1].length];
        int[] prevArr = new int[stair[stair.length-1].length];
        List<String> track = new ArrayList<>();
        prevArr[0] = stair[0][0];
        for(int i = 1 ; i < stair.length ; i++){
            for(int j = 0 ; j <= i ; j++){
                int min = Integer.MAX_VALUE;
                if(j > 0) min = Math.min(min,prevArr[j-1]);
                if(j < i-1) min = Math.min(min,prevArr[j+1]);
                if(j < i) min = Math.min(min,prevArr[j]);

                DPArr[j] = min + stair[i][j];

            }
            for(int k = 0 ; k < prevArr.length; k++){
                prevArr[k] = DPArr[k];
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < DPArr.length ; i++){
            min = Math.min(min , DPArr[i]);
        }
        System.out.println(min);

    }


    public static void main(String[] args){

        int[][] stair = {{2},{4, 4}, {8, 5,6},{4,2,6,2},{1,5,2,3,4}};
        minWeight(stair);
    }

}
