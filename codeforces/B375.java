package codeforces;

import java.util.Scanner;

public class B375 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String count = sc.nextLine();
        String str = sc.nextLine();
        char prev ='.';
        boolean openParenth = false;
        int maxSize = 0;
        int wordCount = 0;
        int iter=0;
        while(iter <str.length() ){
            if(str.charAt(iter) =='(') {
                openParenth = true;
            }
            else if(str.charAt(iter) == ')'){
                openParenth = false;
            }
            else if(!openParenth && Character.isAlphabetic(str.charAt(iter))){
                int tempLength = 0;
                while(iter <str.length()&& Character.isAlphabetic(str.charAt(iter))) {
                    tempLength++;
                    iter++;
                }
                iter--;
                maxSize = Math.max(maxSize,tempLength);
            }
            else if( openParenth && Character.isAlphabetic(str.charAt(iter))
                && !Character.isAlphabetic(str.charAt(iter-1)) ){
                wordCount++;
            }

            iter++;
        }
        System.out.print(maxSize+" "+wordCount);

    }

}
