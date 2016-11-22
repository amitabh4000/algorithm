package ElementsofPI.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SAmitabh on 31-08-2016.
 */
public class rotateMatrix {


    public static void rotate90(List<List<Integer>> A){
        final int matrixSize = A.size()-1;

        for(int i = 0; i < A.size()/2 ; i++){
            for( int j = 1; j < matrixSize -i ; j++){
                int temp1 = A.get(i).get(j);
                int temp2 = A.get(j).get(matrixSize - i);
                int temp3 = A.get(matrixSize - i).get(matrixSize-j);
                int temp4 = A.get(matrixSize-j).get(i);
                A.get(j).set(matrixSize - i ,temp1);
                A.get(matrixSize - i).set(matrixSize-j ,temp2);
                A.get(matrixSize - j).set(i, temp3);
                A.get(i).set( j , temp4);
            }
        }


    }


    public static void main(String[] args) {
        List<List<Integer>> A = new ArrayList<List<Integer>>();
        List<Integer>  a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        List<Integer>  b = new ArrayList<>();
        b.add(4);
        b.add(5);
        b.add(6);
        List<Integer>  c = new ArrayList<>();
        c.add(7);
        c.add(8);
        c.add(9);
        A.add(a);
        A.add(b);
        A.add(c);
        rotate90(A);
    }
}
