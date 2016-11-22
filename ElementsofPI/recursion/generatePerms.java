package ElementsofPI.recursion;

import java.util.*;
public class generatePerms {

    public static List<List<Integer>> genPerms(List<Integer> nums){

       List<List<Integer>> bigList = new ArrayList<>();
       Collections.sort(nums);
        while(true){
            bigList.add(new ArrayList<>(nums));
            nums = nextPerm(nums);
            if(nums == null || nums.size() == 0) break;
        }


     return bigList;
    }

    public static List<Integer> nextPerm(List<Integer> A){

        int ind = A.size() - 1;
            while( ind > 0 && A.get(ind) <= A.get(ind - 1) ){
                ind--;
            }
            if(ind == 0) return new ArrayList<>();
            int smallest = A.get(ind);
            int smallInd = ind;
            for(int i = ind+1; i < A.size();i++){
                if(A.get(i) > A.get(ind-1) && A.get(i) < smallest){
                    smallest = A.get(i);
                    smallInd = i;
                }
            }
            Collections.swap(A,ind-1,smallInd);
            Collections.sort(A.subList(ind,A.size()));
            return A;
    }
    public static void main(String[] args){
        List<Integer> input = new ArrayList<>();
        input.add(4);
        input.add(4);
        input.add(8);
        input.add(0);
//        input.add(9);
//        input.add(13);
//        input.add(15);
//        input.add(20);
//        input.add(2);
//        input.add(10);
        int count=0;
        List<List<Integer>> output = genPerms(input);
        for(int i = 0 ; i < output.size(); i++){
            System.out.print("{");
            for(int j = 0 ; j < output.get(i).size(); j++){
                System.out.print(output.get(i).get(j)+ (j != output.get(i).size()-1 ? ",":""));
            }
            System.out.print("}");
            System.out.println();
        }
    }

}
