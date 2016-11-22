/**
 * Created by SAmitabh on 31-08-2016.
 */

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.io.*;
public class sharePrice {


    public static void main(String[] args) {

        HashMap<String, double[]> map = new HashMap<>();
        double basePrice = 100.00;
        List<String> lines = new ArrayList<String>();
        try {
            lines = Files.readAllLines(Paths.get(args[0]));
        } catch (IOException e) {

        }
        String[] keyName = new String[lines.size()-2];
        double baseprice = Double.parseDouble(lines.get(0));
        String[] time = lines.get(1).split(" +");
        int[] timeInt = new int[time.length];
        for (int i = 0; i < time.length; i++) {
            timeInt[i] = Integer.parseInt(time[i]);
        }
        for (int i = 2; i < lines.size(); i++) {
            double[] temp = new double[time.length];
            String[] str = lines.get(i).split(" +");
            for (int j = 1; j < str.length; j++) {
                temp[j] = Double.parseDouble(str[i]);
            }
            keyName[i-2] = str[0];
            map.put(str[0], temp);
        }
        char[] result = new char[time.length];

        for(String s:keyName){
            double[] temp = map.get(s);
            double[] sell = new double[temp.length];
            double[] buy  = new double[temp.length];
            buy[0] = -1 * temp[0];
            sell[0] = 0;
            for(int i = 1 ; i < temp.length ; i++){
                buy[i] = Math.max( buy[i] , sell[i]);
            }

        }



    }
}
