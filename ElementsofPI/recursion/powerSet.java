package ElementsofPI.recursion;

import java.util.*;
public class powerSet {

    public static List<List<Integer>> powerSet(List<Integer> input) {

        List<List<Integer>> bigList = new ArrayList<>();
        powerHelper(bigList, input, new ArrayList<>(), 0);
        return bigList;
    }

    public static void powerHelper(List<List<Integer>> bigList,
                                   List<Integer> input, List<Integer> selected, int selectRejectInd) {

        if (selectRejectInd == input.size()) {
            bigList.add(new ArrayList<>(selected));
            return;
        }
        selected.add(input.get(selectRejectInd));
        powerHelper(bigList, input, selected, selectRejectInd + 1);
        selected.remove(selected.size()-1);
        powerHelper(bigList,input,selected,selectRejectInd + 1);
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
        List<List<Integer>> output = powerSet(input);
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