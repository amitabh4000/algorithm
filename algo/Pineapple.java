package algo;

/**
 * Created by SAmitabh on 14-07-2016.
 */
import java.util.*;
public class Pineapple{

    public static void main( String[] args) {

        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        int interval =sc.nextInt();
        int toeat = sc.nextInt();

        if( (toeat - first) / interval >= 0 && (toeat - first) % interval == 0 ){
            System.out.println("YES");
        }
        else if( (toeat - first) / interval > 0 && (toeat - first) % interval == 1 ){
            System.out.println("YES");
        }
        else System.out.println("NO");

    }

}
