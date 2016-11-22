package ElementsofPI.Arrays;

import java.util.*;

public class dutchFlag {
    public static enum Color{ RED, WHITE, BLUE}

    public static void dutchFlagPartition( int pivotIndex, List<Color> A){

        Color pivot = A.get(pivotIndex);
        int smaller = 0 , equal = 0, larger = A.size()-1;
        while(equal <larger){

            if(A.get(equal).ordinal() < pivot.ordinal()){
                 Collections.swap(A, smaller++,equal++);
            }
            if(A.get(equal).ordinal() == pivot.ordinal()){
                equal++;
            }
            else{
                Collections.swap(A , equal , larger--);
            }

        }
    }

    public static void  main(String[] args){
        List<Color> A = new ArrayList<>();
        A.add(Color.WHITE);
        A.add(Color.BLUE);
        A.add(Color.BLUE);
        A.add(Color.RED);
        A.add(Color.BLUE);
        A.add(Color.WHITE);
        A.add(Color.BLUE);
        A.add(Color.RED);
        dutchFlagPartition(3, A);
    }
}

