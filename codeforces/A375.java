package codeforces;

import java.util.*;


public class A375 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int x2 = in.nextInt();
        int x3 = in.nextInt();
        System.out.println(Math.max(x3 , Math.max(x1,x2))- Math.min(x3 , Math.min(x1,x2)) );

    }
}
