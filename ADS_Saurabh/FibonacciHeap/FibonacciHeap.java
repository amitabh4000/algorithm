package ADS_Saurabh.FibonacciHeap;


import java.util.*;
public class FibonacciHeap {

    PopularHashtag popHashtag;

    public FibonacciHeap(PopularHashtag popHashtag){
         this.popHashtag =popHashtag;
    }
    public static class FibonacciNode{

        private FibonacciNode next;   // Next and previous elements in the list
        private FibonacciNode prev;
        private FibonacciNode parent; // Parent in the tree, if any.
        private FibonacciNode child;  // Child node, if any.

        private int degree = 0;       // Number of children
        private boolean ifMarked = false; // Whether this node is marked

        public String key;     // Element being stored here
        public int value;         // Its value to compare with otherNodes


        public FibonacciNode(String key, int value){
            this.key = key;
            this.value = value;
            next = this;
            prev = this;
        }
    }



    private FibonacciNode maxVal = null;
    private int size = 0;




    public void insertNode(FibonacciNode node ){
        maxVal = mergeList(maxVal , node);
        //System.out.println("Inserting max : "+maxVal.key+" and the new node is: "+node.key);
        size++;

    }

    public void increaseVal(FibonacciNode node , int val){

        node.value += val;
        if(node.parent !=null && node.parent.value <= node.value){
              separateNode(node);
        }

        if(node.value >= maxVal.value) {
            maxVal = node;
        }

    }

    public void separateNode(FibonacciNode node){

        node.ifMarked = false;

        if(node.parent == null){
            return;
        }

        if(node.parent.child == node){
            if(node.next != node){
                node.parent.child = node.next;
            }
            else{
                node.parent.child = null;
            }
        }
        node.parent.degree--;

        if(node.next != node){
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }

        node.next = node;
        node.prev = node;
        maxVal = mergeList(node,maxVal);
        if(node.parent.ifMarked){
            separateNode(node.parent);
        }
        else{
            node.parent.ifMarked = true;
        }
        node.parent = null;

    }

    public FibonacciNode extractMax(){


        if(maxVal == null){
            //System.out.println("max is null");
            return null;
        }
        size--;
        FibonacciNode maxRes = maxVal;
        //System.out.println(" The max from extract max is: "+maxRes.key+" with value: "+maxRes.value);
        if(maxVal.next != maxVal){
            maxVal.next.prev = maxVal.prev;
            maxVal.prev.next = maxVal.next;
            maxVal = maxVal.next;;
        }
        else{

            maxVal = null;
        }
        if(maxRes.child != null){

            FibonacciNode childNode = maxRes.child;
            childNode.parent = null;
            FibonacciNode temp = childNode.next;
            //System.out.println(temp.key);
            while(temp != childNode){

                temp.parent = null;
                temp = temp.next;
            }

        }

        maxVal = mergeList(maxVal , maxRes.child);
        if(maxVal == null){
            //System.out.println("Max is: "+maxRes.key);
            return maxRes;
        }


        List<FibonacciNode> rootList = new ArrayList<>();
        rootList.add(maxVal);
        FibonacciNode temp = maxVal.next;
        //System.out.println("maxVal is: "+maxVal.key+"temp is: "+temp.key);
        while(temp != maxVal){
            rootList.add(temp);
            temp = temp.next;
        }


        Map<Integer,FibonacciNode> map = new HashMap<>();
        for(FibonacciNode node:rootList) {
            //System.out.println("The node from the list is: "+node.key);
            while (true) {
                if (!map.containsKey(node.degree) || map.get(node.degree) == null) {
                    map.put(node.degree, node);
                    break;
                }
                FibonacciNode other = map.get(node.degree);
                map.put(node.degree, null);
                FibonacciNode min;
                FibonacciNode max;
                if (node.value > other.value) {
                    min = other;
                    max = node;
                } else {
                    min = node;
                    max = other;
                }


                min.next.prev = min.prev;
                min.prev.next = min.next;
                min.next = min.prev = min;
                max.child = mergeList(max.child, min);
                min.parent = max;
                max.degree++;
                max.ifMarked = false;
                node = max;
            }
            if (node.value >= maxVal.value) maxVal = node;
        }
        return maxRes;
    }

    private FibonacciNode mergeList(FibonacciNode first , FibonacciNode second){

        if(first == null && second == null) return null;
        if(first == null && second != null) return second;
        if(second == null && first != null) return first;

        FibonacciNode firstNext = first.next;
        first.next = second.next;
        second.next.prev = first;
        second.next = firstNext;
        firstNext.prev = second;


        if(first.value > second.value) return first;
        else return second;
    }

    public List<FibonacciNode> findPopularHashtags(int n){

        List<FibonacciNode> hashtagList = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            FibonacciNode currMax = extractMax();
            hashtagList.add(currMax);
        }

        for(int i = 0 ; i < n ; i++){
            FibonacciNode newNode = new FibonacciNode(hashtagList.get(i).key,hashtagList.get(i).value);
            insertNode(newNode);
            popHashtag.nodeMap.put(hashtagList.get(i).key,newNode);
        }

       return hashtagList;
    }
}
