package ElementsofPI.PrimitiveTypes;

/**
 * Created by SAmitabh on 22-08-2016.
 */
public class isPlaindrome {

    public boolean isPalindrome(int x){

        return  x < 0 ? false :x == reverse(x);
    }

    public int reverse(int x){
        int res = 0;
        while( x > 0){
            res = res * 10 + x%10;
            x /= 10;
        }
        return res;
    }
    public static void main(String args[]){
        isPlaindrome pal = new isPlaindrome();
        System.out.println(pal.isPalindrome(-7997));

    }
}
