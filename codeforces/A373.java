package codeforces;

import java.util.*;

/**
 * Created by SAmitabh on 23-09-2016.
 */
public class A373 {

    public static void main(String[] args) {


        int count = 0;
        int prev = -1;
        int curr = 0;
        Scanner sc = new Scanner(System.in);
        count = sc.nextInt();
        for(int i = 0 ; i < count; i++){
            prev = curr;
            curr = sc.nextInt();
            if(curr < 0 || curr >15){
                System.out.println(-1);
                return;
            }
        }
        if(count<2 && curr != 0 && curr != 15) {
            System.out.println(-1);
            return;
        }
        if(curr == 0)  System.out.println("UP");
        else if(prev > curr || curr == 15) System.out.println("DOWN");
        else System.out.println("UP");
        return;
    }
}
