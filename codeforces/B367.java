package codeforces;
//import java.util.*;
//public class B367 {
//
//
//    public static void main(String[] args){
//
//
//        int[] shopArr;
//        Scanner scanner = new Scanner(System.in);
//        int numShops = scanner.nextInt();
//        shopArr = new int[numShops];
//        int[] indArray = new int[100*1000 + 5];
//        for(int i = 0 ; i < numShops ; i++){
//            indArray[scanner.nextInt()]++;
//        }
//        for(int i = 1 ; i < 100*1000 ; i++){
//            indArray[i] += indArray[i-1];
//        }
//        int numDays = scanner.nextInt();
//        for(int i = 0 ; i < numDays ; i++) {
//            int count = 0;
//            int moneyAvail = scanner.nextInt();
//            if (moneyAvail >= 100 * 1000) {
//                count = numShops;
//            }
//            else{
//                count = indArray[moneyAvail];
//            }
//            System.out.println(count);
//        }
//
//    }
//}



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by pallavi on 11/8/16.
 */
public class B367 {
    private static int n;
    private static int[] x;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        x = new int[n + 1];
        x[0] = 0;
        for (int i = 0; i < n; i++) {
            x[i + 1] = Integer.parseInt(tokenizer.nextToken());
        }
        Arrays.sort(x);

        int q = Integer.parseInt(reader.readLine());
        for (int i = 0; i < q; i++) {
            int m = Integer.parseInt(reader.readLine());
            int st = 0, en = n + 1;
            while (st + 1 < en) {
                int md = (st + en) / 2;
                if (x[md] <= m) {
                    st = md;
                } else {
                    en = md;
                }
            }
            System.out.println(st);
        }
    }
}
