package ElementsofPI.BST;

import java.util.*;
public class ABSqrt2 {

    public static class ABSqrrt2 implements Comparable<ABSqrrt2>{

        public int a;
        public int b;
        public double val;
        public ABSqrrt2(int a, int b){
            this.a = a;
            this.b = b;
            val = a + b * Math.sqrt(2);
        }


        @Override
        public int compareTo(ABSqrrt2 o) {
            return Double.compare(val,o.val);
        }
    }

    public static List<Double> firstN(int n){
        List<Double> list = new ArrayList<>();
        NavigableSet<Double> set = new TreeSet<>();
        int a = 0;
        int b = 1;
        while(list.size() < n){
            set.add(new ABSqrrt2(a++,b).val);
            set.add(new ABSqrrt2(a,b++).val );
            list.add(set.pollFirst());
        }
        return list;
    }
    public static void main(String[] args){
        int count= 8;
        List<Double> list = firstN(count);
        int i =0;
        while(i <count) {
            System.out.print(list.get(i)+",");
            i++;
        }
    }

}
