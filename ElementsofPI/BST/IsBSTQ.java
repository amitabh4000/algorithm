package ElementsofPI.BST;

import java.util.*;

/**
 * Created by SAmitabh on 15-09-2016.
 */
public class IsBSTQ {

    public static class QueueEntry{
        public TreeNode<Integer> node;
        public int lowerBound , upperBound;
        public QueueEntry(TreeNode<Integer> node , int lowerBound , int upperBound){
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
            this.node = node;
        }

        public static boolean IsBSTQ(TreeNode<Integer> root){

            Queue <QueueEntry> queue = new LinkedList<>();
            queue.offer(new QueueEntry(root , Integer.MIN_VALUE , Integer.MAX_VALUE));
            QueueEntry headEntry;
            while((headEntry = queue.poll()) != null){
                if(headEntry.node.data <headEntry.lowerBound
                        || headEntry.node.data < headEntry.upperBound){
                    return false;
                }
                queue.offer(new QueueEntry(headEntry.node.left ,
                                           headEntry.lowerBound ,
                                           headEntry.node.data));
                queue.offer(new QueueEntry(headEntry.node.left ,
                                           headEntry.lowerBound ,
                                           headEntry.node.data));
            }
        return true;
        }
    }


}
