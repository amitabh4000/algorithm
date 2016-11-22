package ElementsofPI.Arrays;

import java.util.*;
/**
 * Created by SAmitabh on 30-08-2016.
 */
public class spiralOrderMatrix {

    public static List<Integer> matrixSpiralOrder(List<List<Integer>> matrix){
        List<Integer> res = new ArrayList<>();
        final int[][] SHIFT = {{0,1},{1,0},{0,-1},{-1,0}};
        int x = 0 ,y = 0, nextX = 0, nextY = 0 , dir =0;
        for(int i = 0 ; i < matrix.size()*matrix.size();i++){
            int val = matrix.get(x).get(y);
            matrix.get(x).set(y,0);
            nextX = x + SHIFT[dir][0];
            nextY = y + SHIFT[dir][1];
            if(nextX < 0 || nextX >= matrix.size() ||
                    nextY < 0 || nextY >= matrix.size() ||
                    matrix.get(x).get(y) == 0){
                dir = (dir+1)%4;
                nextX = x + SHIFT[dir][0];
                nextY = y + SHIFT[dir][1];
            }
            x = nextX;
            y = nextY;
        }

        return res;
    }
}
