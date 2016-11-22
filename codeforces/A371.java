package codeforces;

import java.util.*;
/**
 * Created by SAmitabh on 13-09-2016.
 */
public class A371 {

    public static void main(String[] args){


        long result = 0;

        Scanner sc = new Scanner(System.in);
        long l1 = sc.nextLong();
        long r1 = sc.nextLong();
        long l2 = sc.nextLong();
        long r2 = sc.nextLong();
        long k = sc.nextLong();

        if(l1> r1 || l2 > r2) {
            System.out.println(0);
            return;
        }
        long beg = l2 > l1? l2 : l1;
        long end = r2 < r1 ? r2 :r1;
        result = end >= beg ? end - beg +1 : 0;
        System.out.println(k >= beg && k <= end ? result-1 : result);
        sc.close();
    }
}
