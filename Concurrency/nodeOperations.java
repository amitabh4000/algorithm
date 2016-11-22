//package Concurrency;
//
//import java.util.concurrent.locks.*;
//
///**
// * Created by SAmitabh on 08-10-2016.
// */
//public class nodeOperations<T> {
//     class Node{
//         T item;
//         int key;
//         Node next;
//     }
//     Node head;
//     Lock lock = new ReentrantLock();
//    public boolean remove(T item){
//        int key = item.hashCode();
//        Node pred = head;
//        Node curr = pred.next;
//        while(curr.key <=key){
//            if(item == curr.item){
//                break;
//            }
//            pred = curr;
//            curr = curr.next;
//        }
//        try{
//            curr.lock(),pred.lock();
//            if(validate(pred , curr)){
//                if(curr.key == key){
//                    pred.next = curr.next;
//                    return true;
//                }
//                else{
//                    return false;
//                }
//            }
//        }
//        finally {
//            curr.unlock();
//            pred.unlock();
//        }
//    }
//
//    private boolean validate(Node pred , Node curr){
//        Node node = head;
//        while(node.key <=pred.key){
//            if(node.key == pred.key){
//                return node.next == curr;
//            }
//            node = node.next;
//        }
//        return false;
//    }
//
//}
//
////// If (we find the item) {then curr has that item and pred has the pred}
/////  else { pred has the key just smaller than the item and curr just larger}