package algo;

/**
 * Created by SAmitabh on 25-07-2016.
 */
public class matrixsum {




    public static void main(String[] args){

        int[][] matrix ={{3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}};

        int m = matrix.length;
        int n = matrix[0].length;
        int[][]DPstore = new int[m+1][n+1];

        // for(int i = 0 ; i < matrix.length ; i++){
        //     int sumrow = 0;
        //     for(int j = 0 ; j < matrix[0].length ; j++ ){
        //         sumrow += matrix[i][j] ;
        //         DPstore[i+1][j+1] = DPstore[i][j+1] + sumrow ;
        //     }
        // }

        for(int i = 0 ; i < m ; i++){
            System.out.print("{");
            int sum =0;
            for(int j = 0 ; j<n ; j++){
                sum = sum + matrix[i][j];
                DPstore[i+1][j+1] = DPstore[i][j+1] +sum;
                System.out.print(DPstore[i + 1][j + 1] + ",");
            }
            System.out.println("}");
        }
    }
}
