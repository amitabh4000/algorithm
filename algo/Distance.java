package algo;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
/**
 * Created by SAmitabh on 14-07-2016.
 */
public class Distance {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //String input = sc.nextLine();
        BigDecimal bd = new BigDecimal(sc.next()).stripTrailingZeros();
        System.out.println(bd);

//        int power = 0;
//        int ind = input.length()-1;
//        //System.out.println(ind);
//        int mult =1;
//        while(Character.isDigit(input.charAt(ind))){
//            power += (input.charAt(ind)-'0')*mult;
//            mult = mult*10;
//            ind--;
//        }
//        String number = input.substring(0 , input.length());
//        //if(number.contains("."))
//        String[] num = number.split("\\.");
//        int i =0;
//        //System.out.println("num[1] is: "+num[1]);
//        StringBuilder sb = new StringBuilder();
//        while(Character.isDigit(num[1].charAt(i))){
//            sb.append(num[1].charAt(i));
//            i++;
//        }
//        num[1] =sb.toString();
//        sb = new StringBuilder();
//        sb.append(num[0]);
//        int lengthD = num[1].length();
//        i = 0;
//        boolean putdecimal = false;
//        while(power> 0 || lengthD >0 ){
//            if(power == 0){
//                if(putdecimal == false) {
//                    sb.append(".");
//                    putdecimal = true;
//                }
//                sb.append(num[1].charAt(i));
//                i++;
//                lengthD--;
//                continue;
//            }
//            if(lengthD == 0 ){
//                sb.append(0);
//                power --;
//                continue;
//            }
//            sb.append(num[1].charAt(i));
//            i++;
//            power--;
//            lengthD--;
//        }
//        String res="";
//        i = 0;
//        while(sb.charAt(i)=='0'){
//            sb.deleteCharAt(i);
//        }
//        if(sb.charAt(0)=='.') res = "0" +sb.toString();
//        else res = sb.toString();
//        if(res.contains(".")&& res.charAt(res.length()-1)=='0') {
//            res = res.split("\\.")[0];
//        }
//        System.out.println(res);
        return;
    }

}
