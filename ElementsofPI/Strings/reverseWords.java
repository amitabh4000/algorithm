package ElementsofPI.Strings;

/**
 * Created by SAmitabh on 10-11-2016.
 */
public class reverseWords {
    public static String reverseWords(String s){

        s = reverse(s);
        StringBuilder sb = new StringBuilder();
        int i = 0,prev =0;
        while(i  <  s.length()){
            while(i < s.length() && s.charAt(i) != ' '){
                i++;
            }
            sb.append(reverse(s.substring(prev,i)));
            while((i < s.length() && s.charAt(i) == ' ')){
                i++;
                sb.append(' ');
            }
            prev = i;
        }
        return sb.toString();
    }


    public static String reverse(String s){


        int length = s.length();
        char[] letters = s.toCharArray();
        for(int i = 0; i < length/2; i++){
            char temp = letters[length - i -1];
            letters[length - i - 1] =letters[i];
            letters[i] = temp;
        }
        return new String(letters);
    }

    public static void main(String[] args){

        System.out.println(reverseWords("Sometimes you eat the bar and sometimes well, the bar eats you"));
    }

}
