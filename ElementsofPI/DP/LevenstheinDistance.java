package ElementsofPI.DP;

/**
 * Created by SAmitabh on 10-11-2016.
 */
public class LevenstheinDistance {

    public static int LevenstheinDist(String s1 , String s2){

        int n = s1.length();
        int m = s2.length();
        int[][] table = new int[m+1][n+1];
        for(int i = 0 ; i <= m; i++){
            table[i][0] = i;
        }

        for(int j = 0 ; j <= n; j++){
            table[0][j] = j;
        }

        for(int i = 1; i <= m ; i++){
            for(int j = 1; j <= n ; j++){
                if(s1.charAt(j-1) == s2.charAt(i-1)){
                    table[i][j] = table[i-1][j-1];
                }
                else{
                    table[i][j] = Math.min(Math.min(table[i-1][j-1]+1,table[i-1][j]+1)
                                           ,table[i][j-1]+1);
                }
            }
        }
        return table[m][n];
    }

    public static void main(String[] args){
        System.out.println(LevenstheinDist("saturday","sundays"));
    }

}
