package ElementsofPI.Arrays;

import java.util.*;
public class buySellStockTwice {


    public static int buySellStock(List<Integer> A){

        int length = A.size();
        List<Integer> fScan = new ArrayList<Integer> (Collections.nCopies(length,0));
        List<Integer> bScan = new ArrayList<Integer> (Collections.nCopies(length,0));
        int res = 0;
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 0 ; i < A.size() ; i++){
            minPrice = Math.min(minPrice , A.get(i));
            maxProfit = Math.max(maxProfit , A.get(i)-minPrice);
            fScan.set(i , maxProfit);
        }
        int maxPrice = 0;
        maxProfit = 0;
        for(int i = length-1 ; i >=0 ; i--){
            maxPrice = Math.max(maxPrice , A.get(i));
            maxProfit = Math.max(maxProfit, maxPrice - A.get(i));
            bScan.set(i , maxProfit);
            if(i > 0)
            res = Math.max(res , bScan.get(i) + fScan.get(i-1));
        }
        return Math.max(res , bScan.get(0));
    }
    public static void main(String[] args) {
        List<Integer> A = new LinkedList<>();
        A.add(9);
        A.add(9);
        A.add(3);
        A.add(6);
        A.add(6);
        A.add(9);
        A.add(3);
        A.add(9);
       buySellStock(A);
    }




}
