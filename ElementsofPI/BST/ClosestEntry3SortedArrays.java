//package ElementsofPI.BST;
//
//import java.util.*;
//
//public class ClosestEntry3SortedArrays {
//
//
//    public static class ArrayData implements Comparable<ArrayData>{
//
//        int data;
//        int idx;
//
//        public ArrayData(int data , int idx){
//            this.data = data;
//            this.idx = idx;
//        }
//
//
//        @Override
//        public int compareTo(ArrayData o) {
//            int res = Integer.compare(data,o.data);
//            if(res == 0){
//                res = Integer.compare(idx , o.idx);
//            }
//            return res;
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(data , idx);
//        }
//
//        @Override
//        public boolean equals(Object obj) {
//            if(obj == null || !(obj instanceof ArrayData)){
//                return false;
//            }
//            if(this == obj){
//                return true;
//            }
//            ArrayData that = (ArrayData) obj;
//            return this.data == that.data && this.idx == that.idx;
//        }
//    }
//
//    public List<Integer> minDistSortedArray(List<List<Integer>> sortedArrays ){
//
//         List<Integer> heads = new ArrayList<>(sortedArrays.size());
//         for(List<Integer> list:sortedArrays){
//             heads.add(0);
//         }
//        int result = Integer.MAX_VALUE;
//        NavigableSet<ArrayData> currHead = new TreeSet<>();
//        for(int i = 0 ; i < sortedArrays.size();i++){
//            currHead.add(new ArrayData(i , sortedArrays.get(i).get(heads.get(i))));
//        }
//        while(true){
//            result = Math.min(result , currHead.last().data-currHead.first().data);
//            int nextMinInd = currHead.first().idx;
//            heads.set(nextMinInd ,)
//        }
//
//    }
//}
