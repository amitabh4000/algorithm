package codeforces;

import java.util.*;

    public class B371 {

        public static void main(String[] args) {


            int result = 0;
            int[] a = new int[3];
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            Set<Integer> set = new HashSet<>();
            int count = 0;

            for (int i = 0; i < num; i++) {
                int temp = sc.nextInt();
                if (!set.contains(temp)) {
                    set.add(temp);
                     if(count < 3)a[count] = temp;
                     count++;
                }


            }
            Arrays.sort(a);
            if (count < 3) {
                System.out.println("YES");
            } else if (count == 3 && a[1] - a[0] == a[2] - a[1]) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            sc.close();
        }
}
