package algo;
import java.util.*;
import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
/**
 * Created by SAmitabh on 14-06-2016.
 */
public class TimePlay {
    public static void main(String args[]){
        int a=2;
        long milis=System.currentTimeMillis();
        System.out.println("in milisec"+milis);
        Date date=new Date(milis);
        String dateStr=DateFormat.getDateInstance().format(date);
        System.out.println("in simple format"+dateStr);
        System.out.println(new SimpleDateFormat("EE", Locale.ENGLISH).format(date.getTime()));
    }
}
