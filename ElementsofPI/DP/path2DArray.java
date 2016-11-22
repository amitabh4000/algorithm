package ElementsofPI.DP;

/**
 * Created by SAmitabh on 10-11-2016.
 */
public class path2DArray {

    public static int path(int m , int n){

        int[][]table = new int[m][1];

        for(int i = 0; i < m ; i++){
            table[i][0] = 1;
        }


        for(int j  = 1; j < n ; j++){
            for(int i = 1; i < m ; i++){
                table[i][0] = table[i-1][0] + table[i][0];
            }
        }
        return table[m-1][0];
    }

    public static void main(String[] args){

        System.out.println(path(10,3));
    }

}
