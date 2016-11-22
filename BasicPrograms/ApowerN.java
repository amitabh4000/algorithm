package BasicPrograms;

/**
 * Created by SAmitabh on 06-10-2016.
 */
public class ApowerN {

    public static long power(long a , long n){

        a = a % Long.MAX_VALUE;
        if(n == 0) return 1;
        long res = power(a,n/2);
        if(n%2 != 0){
            return (a * res * res)%Long.MAX_VALUE;
        }
        else{
            return (res * res) %
                    Long.MAX_VALUE;
        }


    }
    public static void main(String[] args){

        int a = 7;
        int n = 15;
        System.out.println(power(a,n));
    }

}
