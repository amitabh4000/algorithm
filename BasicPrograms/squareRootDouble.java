package BasicPrograms;

/**
 * Created by SAmitabh on 13-10-2016.
 */
public class squareRootDouble {

    public static double squareRoot(double num) {

       double temp = abs(num);
       double guess = temp/2;

       while(0.000001 <= abs(temp - guess*guess)){
            System.out.println(guess);
            try {
                Thread.sleep(100);
            }
            catch(InterruptedException ie){

            }
            guess = (guess + temp/guess)/2;
        }
        return guess;
    }
    static double abs(double a){
        return a < 0 ? (-1 * a) : a;
    }

    public static void main(String[] args){

        //squareRootDouble(34);
        double arg = -1 * 35.9999;
        System .out.println(squareRoot(arg));
    }
}
