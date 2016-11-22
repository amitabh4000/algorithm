package ElementsofPI.recursion;

import java.util.*;
public class towerHanoi {

    private static final int NUM_PEGS = 3;
    public static void computeHanoi(int numRings){

        List<Deque<Integer>> pegs = new ArrayList<>();

        for(int i = 0 ; i < NUM_PEGS; i++){
            pegs.add(new LinkedList<>());
        }

        for(int i = numRings ; i >= 1; i--){
            pegs.get(0).add(i);
        }

        computeHelper(numRings,pegs,0,1,2);
    }

    public static void computeHelper(int numRings,List<Deque<Integer>> pegs,
                                     int fromPeg,int toPeg,int usePeg) {
        if (numRings > 0){
            computeHelper(numRings - 1, pegs, fromPeg, usePeg, toPeg);
            System.out.println("num rings rem: "+numRings+"Moving from: " + fromPeg + " to: " + toPeg);
            computeHelper(numRings - 1, pegs, usePeg, toPeg, fromPeg);
        }
    }

    public static void main(String[] args){

        computeHanoi(4);
    }
}
