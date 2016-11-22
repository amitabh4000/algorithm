package algo;

/**
 * Created by SAmitabh on 21-07-2016.
 */
public class BinarySearch {
      public static int binarysearch(int[] arr , int key){
          int res =0;
          int beg = 0;
          int end = arr.length -1;

          while(beg <= end){
           int mid = (beg+end)/2;
              //if(arr[mid]== key) return mid;
            if(arr[mid]> key){
               end = mid-1;
           }
              else{
               beg = mid+1;
           }
          }
          System.out.println(beg+": "+end);
          return beg;
      }


   public static void main(String[] args){
      int[] arr = {0, 1,2,3,5,5,5,5,6};
       System.out.println(binarysearch(arr,5));
   }
}
