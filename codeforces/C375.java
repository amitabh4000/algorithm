package codeforces;

import com.sun.deploy.util.SyncAccess;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by SAmitabh on 06-10-2016.
 */
public class C375 {

    public static class recordCount{
        int val;
        int count;
        public recordCount(int val , int count){
            this.val = val;
            this.count = count;
        }
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int songCount = sc.nextInt();
        int favNum = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<recordCount> queuemin = new PriorityQueue<>(new Comparator<recordCount>() {
            @Override
            public int compare(recordCount r1, recordCount r2) {
                return Integer.compare(r1.count,r2.count);
            }
        });
        PriorityQueue<recordCount> queuemax = new PriorityQueue<>(new Comparator<recordCount>() {
            @Override
            public int compare(recordCount r1, recordCount r2) {
                return Integer.compare(r2.count,r1.count);
            }
        });

        int[] arr = new int[songCount];
        for(int i = 0; i<songCount;i++){
            int val = sc.nextInt();
            arr[i] =val;
            if(map.containsKey(val)){
                map.put(val ,map.get(val)+1);
            }
            else{
                map.put(val,1);
            }
        }

        for(int i = 1; i <= favNum;i++){
            if( !map.containsKey(i)){
                map.put(i ,0);
            }
        }

        for(int i = 1 ; i <= favNum; i++){

            queuemin.offer(new recordCount(i,map.get(i)));
            //queuemax.offer(new recordCount(arr[i],map.get(arr[i])));
        }
        int avg = songCount/favNum;
        int changes = 0;
        for(int i = 0 ; i < arr.length; i++){
            if(queuemin.peek().count >=avg) break;
            else{
                if(arr[i] > favNum ||( map.get(arr[i]) > avg)){
                    changes++;
                    map.put(arr[i],map.get(arr[i])-1);
                    arr[i] = queuemin.peek().val;
                    map.put(arr[i],map.get(arr[i])+1);
                    queuemin.poll();
                    queuemin.offer(new recordCount(arr[i],map.get(arr[i])));
                }
            }
        }
        System.out.println(avg+" "+ changes);
        for(int i = 0 ; i< arr.length; i++){
            System.out.print(arr[i]+" ");
        }

    }

}
