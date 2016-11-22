//package ElementsofPI.recursion;
//
//import java.util.*;
//public class GrayCode {
//
//
//    public static List<Integer> evalGray(int numBits){
//
//        if(numBits == 0){
//            List<Integer> ret = new ArrayList<>();
//            ret.add(0);
//            return ret;
//        }
//        if(numBits == 1){
//            List<Integer> ret = new ArrayList<>();
//            ret.add(0);
//            ret.add(1);
//            return ret;
//        }
//        List<Integer> firstList = evalGray(numBits-1);
//        int leadingBitOne = 1 << (numBits-1);
//
//        List<Integer> reflection = new ArrayList<>();
//        for(int i = firstList.size()-1 ; i >= 0 ; i--){
//            reflection.add()
//        }
//
//    }
//}
