package LeetCodeDiscuss;

import java.util.*;
public class MidLowHigh {

    public static List<Integer> midLowHigh(List<Integer> list){

        int beg = 0;
        int end = list.size()-1;
        while(beg < end)
        if(tellType(list.get(beg)).equalsIgnoreCase("high")){
            if(!tellType(list.get(end)).equalsIgnoreCase("high")) {
                int temp = list.get(beg);
                list.set(beg, list.get(end));
                list.set(end, temp);
                end--;
                beg++;
            }
            else{
                end--;
            }
        }
        else{
            beg++;
        }
        beg = 0;
        end = end-1;

        while(beg < end)
            if(tellType(list.get(beg)).equalsIgnoreCase("mid")){
                if(!tellType(list.get(end)).equalsIgnoreCase("mid")) {
                    int temp = list.get(beg);
                    list.set(beg, list.get(end));
                    list.set(end, temp);
                    end--;
                    beg++;
                }
                else{
                    end--;
                }
            }
            else{
                beg++;
            }
        return list;
    }
    public static String tellType(int num){
        if(num <= 5) return "low";
        else if(num <10) return "mid";
        else return "high";
    }

    public static void main(String[] args){
        List<Integer> list1 = new ArrayList<>();
        list1.add(5);
        list1.add(9);
        list1.add(23);
        list1.add(2);
        list1.add(6);
        list1.add(8);
        list1.add(22);
        list1.add(4);
        list1.add(12);
        List<Integer> list = midLowHigh(list1);
        for(int nums:list){
            System.out.println(nums+",");
        }
    }

}
