package BloombergCodeCon;

import java.util.PriorityQueue;
import java.util.Scanner;
//Your submission should *ONLY* use the following class name
public class Cafe
{
    public static void main(String[] args)
    {

        Scanner stdin = new Scanner(System.in);
        int num = stdin.nextInt();
        int ind = stdin.nextInt();
        int res = 0;
        int samecount = 0;
        int second = Integer.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] order = new int[num];
        for(int i = 0 ; i < num ; i++){
            order[i] = stdin.nextInt();
            pq.add(order[i]);
        }
        for(int i = 0 ; i < num ; i++){
           if(order[i] > order[ind]) res += 2;
            if(order[i] > order[ind]){
                second = Math.min(second,order[i]);
            }
        }
        for(int i = num-1 ; i>= 0; i--){
            if(order[i] == order[ind]) samecount++;
            if(order[i] == second) break;
        }
        res += samecount*2;
        System.out.println(res+2);
        stdin.close();
    }

}


