//package LeetCodeDiscuss;
//
//import java.util.*;
///**
// * Definition for an interval.
// * public class Interval {
// *     int start;
// *     int end;
// *     Interval() { start = 0; end = 0; }
// *     Interval(int s, int e) { start = s; end = e; }
// * }
// */
//public class Solution {
//    public static class Interval {
//        int start;
//        int end;
//        Interval() { start = 0; end = 0; }
//        Interval(int s, int e) { start = s; end = e; }
//    public int[] findRightInterval(Interval[] intervals) {
//        int[] res = new int[intervals.length];
//        TreeMap<Integer , Integer> tm = new TreeMap<>();
//        for(int i = 0 ; i < intervals.length; i++){
//            tm.put(intervals[i].start , i);
//        }
//
//        for(int i = 0 ; i < intervals.length ; i++){
//            Integer keyRet = tm.ceilingKey(intervals[i].end);
//            if(keyRet == null) res[i] = -1;
//            else{
//                res[i] = tm.get(keyRet);
//            }
//        }
//
//    }
//}
