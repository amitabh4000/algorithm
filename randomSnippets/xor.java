package randomSnippets;

/**
 * Created by SAmitabh on 09-09-2016.
 */
public class xor extends ThreadLocal {

    public static int xor(int n){
        int res = 0;

        for(int i = n  ; i < 6; i++){
            res ^= i;
        }
        return res;
    }

    public static void main(String[] args){
        char c = 33;
        //System.out.println(xor(1));
        //System.out.println(2^3^2^2^'a'^'a'^c);
//        c ^= 'g';
//        c ^= 'h';
//        c ^= 'g';
//        c ^= 0;
//        c ^= 0;
        System.out.println(c);
    }
}
