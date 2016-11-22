package ElementsofPI.DP;

/**
 * Created by SAmitabh on 10-11-2016.
 */
public class fibConstSpace {

    public static int fib(int n){
        if(n == 1) return 1;
        if(n == 2) return 1;
        int prev = 1;
        int prevPrev = 1;
        int val = prev + prevPrev;
        for(int i = 3 ; i <= n ; i++ ){
            val = prev + prevPrev;
            prevPrev = prev;
            prev = val;
        }

        return val;
    }


    public static void main(String[] args){
        System.out.println(fib(3));
    }

}
