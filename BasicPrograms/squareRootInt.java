package BasicPrograms;


public class squareRootInt {

    public static int sqrt(int num){

        long beg = 0;
        long end = num;

        while(beg <= end){

            long mid = (beg+end)/2;
            if(mid *mid == num) return (int)mid;
            else if( mid*mid > num){
                end = mid-1;
            }
            else{
                beg = mid + 1;
            }
        }
        return (int) end;
    }

    public static void main(String[] args){
        int num = 2147483647;
        System.out.printf("root of %d is %d",num,sqrt(num));

    }
}
