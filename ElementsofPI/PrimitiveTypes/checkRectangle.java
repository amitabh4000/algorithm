package ElementsofPI.PrimitiveTypes;
import java.util.*;
/**
 * Created by SAmitabh on 22-08-2016.
 */
public class checkRectangle {

    public boolean isReactangle(int x1,int y1,
                                int x2,int y2,
                                int x3, int y3,
                                int x4, int y4){

        double ox = (x1+x2+x3+x4)/4;
        double oy = (y1+y2+y3+y4)/4;

        double d1 = sqr(x1-ox) + sqr(y1 - oy);
        double d2 = sqr(x2-ox) + sqr(y2-oy);
        double d3 = sqr(x3-ox) + sqr(y3-oy);
        double d4 = sqr(x4-ox) + sqr(y4-oy);
        return d1 == d2 && d2 == d3 && d3 == d4;
    }
    public double sqr(double x){
        return x*x;
    }

}
