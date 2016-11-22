package ElementsofPI.recursion;

import java.util.*;
public class palindromicDisp {

    public static List<List<String>> palDisp(String s){
        List<List<String>> bigList = new ArrayList<>();

         dispHelper(s , bigList , 0, new ArrayList<>());


        return bigList;
    }
     public static void dispHelper(String s , List<List<String>> bigList ,int offset, List<String> list){


         System.out.println("String is: "+s);
         if(s.equals("")){
             bigList.add(new ArrayList<>(list));
             return;
         }
         for(int i = 1 ; i <= s.length() ; i++){
             String prefix = s.substring(0,i);
             if(isPalindrome(prefix)){
                 List<String> outList = new ArrayList<>();
                 for(String str:list){
                     outList.add(str);
                 }
                   outList.add(prefix);
                   dispHelper(s.substring(i),bigList,i,outList);
             }
         }
     }

    public static boolean isPalindrome(String s){

        int i = 0;
        int j = s.length() - 1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args){

        String input = "0204451881";
        List<List<String>> output = palDisp(input);
        for(int i = 0 ; i < output.size(); i++){
            System.out.print("{");
            for(int j = 0 ; j < output.get(i).size(); j++){
                System.out.print(output.get(i).get(j)+ (j != output.get(i).size()-1 ? ",":""));
            }
            System.out.print("}");
            System.out.println();
        }


    }
}

