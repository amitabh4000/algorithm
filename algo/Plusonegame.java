package algo;

class Plusonegame{

    public static String getorder(String s){

        StringBuilder sb = new StringBuilder();
        int plus_count = 0;
        int[] dig_count = new int[10];

        for( int i = 0; i < s.length() ; i++){
            if( s.charAt(i) == '+' ) plus_count++;
            else{
                dig_count[ s.charAt(i)-'0' ]++;
            }
        }
        for(int i = 0 ; i<10 ; i++){
            while(dig_count[i] > 0){
                sb.append(i);
                dig_count[i]--;
            }
            if(plus_count >0) {
                sb.append('+');
                plus_count--;
            }
        }
        while (plus_count > 0){
            sb.append('+');
            plus_count--;
        }
        return sb.toString();
    }
    public static void main(String[] args){
        String str = "++++4++++200++2++1+6++++++";
        String str2 = getorder(str);
        System.out.println(str2);
    }
}
