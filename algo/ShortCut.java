package algo;
import java.util.Scanner;
/**
 * Created by SAmitabh on 06-07-2016.
 */
public class ShortCut {
    public static void RoadWay(){
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int[] arr = new int[count];
        for(int i = 0 ; i <count ; i++ ){
            arr[i] = in.nextInt();
        }
        int[] DP = new int[count + 1];
        DP[0] = 0;
        DP[1] = 1;
        for ( int i = 2; i <= count; i++){
            int min = i;
            min = Math.min(min, DP[i-1]+1);
            min = Math.min(min, arr[i]-i);
        }
    }

    public static void main(String[] args){

    }
}
