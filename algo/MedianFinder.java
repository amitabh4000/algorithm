package algo;
import java.util.*;
/**
 * Created by SAmitabh on 11-07-2016.
 */
class MedianFinder {

    Queue[] q = {new PriorityQueue(), new PriorityQueue(Collections.reverseOrder())};
    int i = 0;

    public void addNum(int num) {
        q[i].add(num);
        System.out.println(q[0].peek() + " before " + q[1].peek());
        q[i^=1].add(q[i^1].poll());
        System.out.println(q[0].peek()+" after " +q[1].peek());
    }

    public double findMedian() {
        return ((int)(q[1].peek()) + (int)(q[i].peek())) / 2.0;
    }
    public static void main(String[] args){
        MedianFinder medianfinder = new MedianFinder();
        medianfinder.addNum(2);
        medianfinder.addNum(1);
        medianfinder.addNum(7);
        medianfinder.addNum(4);
        medianfinder.addNum(2);
    }
};
