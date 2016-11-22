//package ElementsofPI.DP;
//
//
//public class CoinCheck {
//
//    public static int totalValue(int[] coins){
//
//        DPHelper(coins,0,coins.length-1,new int[coins.length][coins.length]);
//
//    }
//
//
//
//    public static int DPHelper(int[] coins,int start,int end,int[][] DP){
//
//        if(DP[start][end]>0) return DP[start][end];
//
//        int[] scores = new int[2];
//        if(start == end) {
//            return coins[start];
//        }
//        DP[start][end] = Math.max(coins[start]+ DPHelper(coins,start+1,end,DP) , coins[end]+ DPHelper(coins,start,end-1,DP));
//        return DP[start][end];
//    }
//}
