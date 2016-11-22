package unordered;

/**
 * Created by SAmitabh on 06-10-2016.
 */
public class maxNumPalindrome {

    public static class palinCount{
        int val;
        int count;
        public palinCount(int val , int count){
            this.val = val;
            this.count = count;
        }
    }

    public static String maxPalindrome(String num){

        StringBuilder sb = new StringBuilder();
        int[] numCount = new int[10];
        int minOdd= 0;
        int minCount = 0;
        boolean isOne = false;
        for(char c:num.toCharArray()){
            numCount[c-'0']++;
        }
        for(int i = 0 ; i <numCount.length;i++){
            if(numCount[i] == 1) {
                minOdd = i;
                minCount = numCount[i];
                isOne = true;
            }
        }
        if( !isOne){
        for(int i = 0 ; i< numCount.length; i++){
               if(numCount[i]%2==1){
                   minOdd = i;
                   minCount = numCount[i];
                   break;
               }
            }
        }
        for(int i = numCount.length-1 ; i >= 0; i--){
            if(numCount[i] != minOdd){
                for(int j = 0; j < numCount[i]/2 ;  j++) {
                    sb.append(i);
                }
            }
        }
        String part1 = sb.toString();
        for(int i = 0 ; i<minCount;i++){
            sb.append(minOdd);
        }

        String part2 = sb.reverse().toString();
        return part1+part2;
}

    public static void main(String[] args){

        String s = maxPalindrome("34569998876661111122233334");
        System.out.print(s);

    }

}
