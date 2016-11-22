package ElementsofPI.Hash;
import java.util.*;
public class CollatzConjecture {

    public static boolean checkCollatz( long max){
        Set<Long> set = new HashSet<>();
        set.add(1L);
        for(int i = 3 ; i <= max ; i += 2){
            Set<Long> innerSet = new HashSet<>();
            long iter = i;
            while(iter >= i) {
                if (!innerSet.add(iter)) {   //// To check whether a loop is stuck
                                             /// check for repetitions.
                    return false;
                }
                if (iter % 2 == 0) iter /= 2;
                else {
                    if (!set.add(iter)) break;
                    long nextIter = iter * 3 + 1;
                    if (nextIter < iter) {
                        throw new ArithmeticException("Collatz overflow");
                    }
                    iter = nextIter;
                }
            }
        }
        return true;
    }
}
