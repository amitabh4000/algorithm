package algo;

/**
 * Created by SAmitabh on 02-07-2016.
 */
public class count {
    public static long count(long n){
        long count = n/100;
        n = n % 100;
        count += n/11 ;
        return count;
    }
    public static long count(long L, long R){
        return count(R) - count(L-1);
    }


    public static void main(String[] args){
        System.out.println(count(0,88 ));
    }
}
