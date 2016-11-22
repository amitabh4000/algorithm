package ElementsofPI.PrimitiveTypes;

/**
 * Created by SAmitabh on 18-08-2016.
 */
public class Snippets {

    public static int parity1(long x){
        int result = 0;
        while( x !=0){
            result ^= 1;
            x &= (x-1);
        }
        return result;
    }

    public static int parity2(long x){
        x ^= x >>> 32;
        x ^= x >>> 16;
        x ^= x >>> 8;
        x ^= x >>> 4;
        x ^= x >>> 2;
        x ^= x >>> 1;
        return (int) x & 1;
    }

    public static long swapbits(long x , int i , int j){

        if( ((x >>> i)& 1) != ((x >>>j)& 1)){

            long bitmask = (1L << i) | (1L << j);
            x ^= bitmask;
        }

        return x;
    }

    public static long reverseBits(long x){
        final int WORD_SIZE = 16;
        final int BIT_MASK = 0xFFFF;
        int[] precomputedReverse = new int[0x10000];
        return precomputedReverse[(int) x & BIT_MASK] <<(3*WORD_SIZE) |
                precomputedReverse[(int) (x >>>WORD_SIZE) & BIT_MASK] <<(2*WORD_SIZE)|
                precomputedReverse[(int) (x >>> 2*WORD_SIZE) & BIT_MASK] <<(WORD_SIZE) |
                precomputedReverse[(int) (x >>> 3*WORD_SIZE) & BIT_MASK];

    }
    static final int NUM_UNSIGN_BITS = 63;
    public static long closestNumSameBitCount( long x){

        for(int i = 0 ; i < NUM_UNSIGN_BITS - 1; i++){
            if(((x >>> i) & 1) != ((x >>> i+1) & 1)){
                x ^= 1 << i | 1 << i+1;
                return x;
            }
        }
        throw new IllegalArgumentException(" All bits are 1 or 0");
    }

    public static long divideXY(long x , long y){
        long result = 0;
        int power = 32 ;
        long yPower = y << power;
        while(y <= x){
            while(x < yPower){
                yPower >>>= 1;
                power--;
            }
            System.out.println("power is: "+  power);
            x -= yPower;
            result += 1 << power;
        }
        return result;
    }

   public static void main(String[] args){
       int x = 34567;
//       System.out.println("parity from 1 is: "+parity1(x));
//       System.out.println("parity from 2 is: "+parity2(x));
       //System.out.println("x after swapping ith and jth bits: "+swapbits(x ,5 , 2));
       System.out.println("divide x by y: "+  divideXY(28, 7));
   }

}
