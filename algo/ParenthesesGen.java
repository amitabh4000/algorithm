package algo;

/**
 * Created by SAmitabh on 08-06-2016.
 */
public class ParenthesesGen {
    private static int count = 0;
    public static void Brackets(int n) {
        //for (int i = 1; i <= n; i++) {
            Brackets("", 0, 0, n);
        //}

    }

    private static void Brackets(String output, int open, int close, int pairs) {
        if((open == pairs)&&(close == pairs)) {
            System.out.println(output+" count is: "+(++count));
        }
            System.out.println("open is: "+open+" close is: " +close);
            if(open < pairs)
                Brackets(output + "(", open+1, close, pairs);
            if(close < open)
                Brackets(output + ")", open, close+1, pairs);
    }
    public static void main(String args[]){
        int a=3;
        Brackets(a);
    }
}
