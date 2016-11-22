package Concurrency;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.concurrent.atomic.*;
/**
 * Created by SAmitabh on 09-09-2016.
 */
public class Factorize {

    private static AtomicLong counter ;
    public long getCounter(){return counter.get();}
    static final int THREAD_NUM = 8;

   public static void multithread(BigInteger num){

    Thread[] threads = new Thread[THREAD_NUM];

    for (int i = 0; i < THREAD_NUM; i++) {
        int id = i;
        threads[i] = new Thread(() -> factorize(num));
        threads[i].start();
    }
}

    //////////////////////////////////

    public static ArrayList<BigInteger> factorize(BigInteger num){
        ArrayList<BigInteger> factors = new ArrayList<>();
        BigInteger curr = num;
        BigInteger fac = BigInteger.valueOf(2);
        while(fac.compareTo(curr)<= 0){
            BigInteger[] divideAndComp = curr.divideAndRemainder(fac);
            if(divideAndComp[1] ==  BigInteger.ZERO){
                factors.add(fac);
            }
            else{
                fac = fac.nextProbablePrime();
            }
        }
        counter.incrementAndGet();
        return factors;
    }

    public static void main(String[] args){
            final BigInteger NUM = BigInteger.valueOf(345);
            multithread(NUM);
    }

}
