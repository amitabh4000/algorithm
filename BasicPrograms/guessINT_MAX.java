package BasicPrograms;
public class guessINT_MAX {

    public static int guessMax(long upperLimit){

        long beg = 0;
        long end = upperLimit;
        while(beg <= end){
            long mid = (beg+end)/2;
            if(isOver(mid)){
                end = mid-1;
            }
            else{
                beg = mid+1;
            }
        }
        return (int)end;
    }

    public static boolean isOver(long val){
        int maxInt = Integer.MAX_VALUE;
        return val > maxInt;
    }

    public static void main(String[] args){

        System.out.println( guessMax(234567675675L) );
    }
}
