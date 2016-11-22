package algo.Longest_substring_only_2_unique_characters;
import java.util.*;
/**
 * Created by SAmitabh on 11-07-2016.
 */
public class UniqueKChars {

    public String UniqueKChar(String str , int k ){
        String result = "";
        int start = 0;
        int max = 0;
        HashMap<Character , Integer> hm = new HashMap<> ();

        for( int i = 0 ; i < str.length() ; i++) {
            char c = str.charAt(i);
            if (hm.containsKey(c)) {
                hm.put(c, hm.get(c) + 1);
            } else {
                hm.put(c, 1);
            }
            if (hm.size() > k) {
                if ((i - start) > max) {
                    result = str.substring(start, i);
                    max = i - start;
                }
                while (hm.size() > k) {
                    char a = str.charAt(start);

                    int count = hm.get(a);
                    if (count > 1) {
                        hm.put(a, count - 1);
                    } else {
                        hm.remove(a);
                    }
                    start++;
                }

            }
        }
        if( (str.length()-start ) > max ){
            result = str.substring(start , str.length());
        }
            return result;
    }

    public static void main(String[] args){

        int k = 3;
        String str = "abccccccccaaddddeeee";
        UniqueKChars uniqueKChars = new UniqueKChars();
        System.out.println(uniqueKChars.UniqueKChar(str , k));
    }
}
