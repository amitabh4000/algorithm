package algo;
import java.util.Scanner;
/**
 * Created by SAmitabh on 06-07-2016.
 */
public class Cellphone {
    public static void phone(){
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int[] arr = new int[count];
        int[] pattern = new int[2*count];
        int nextint = in.nextInt();
        if(nextint == 0) nextint = 11;
        int div = (nextint-1)/3;
        int rem = (nextint-1)%3;
        for(int i = 1 ; i < count ; i++ ){
            nextint = in.nextInt();
            int divcurr = (nextint-1) / 3;
            int remcurr = (nextint-1) % 3;
            pattern[2*i-2] = divcurr - div;
            pattern[2*i-1] = remcurr - rem;
        }
        boolean[] bool = new boolean[10];
        for( int i = 1 ; i <=9 ; i++){
            int div2 = i/3;
            int rem2 =  i%3;
            for(int j = 0 ; j < (2 * count - 2) ; j=j+2){
                int res = (pattern[j]+div2)*3 + pattern[j+1]+rem2;
                if(res < 0 || res == 10 || res <11){
                    bool[i] = false;
                    break;
                }
                else{
                    div2 = res/3;
                    rem2 = res%3;
                }
            }
        }

    }

    public static void main(String[] args){

    }
}
