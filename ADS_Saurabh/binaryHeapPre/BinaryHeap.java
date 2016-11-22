package ADS_Saurabh.binaryHeapPre;

import java.util.*;
public class BinaryHeap {

        public static class HeapNode {
            int val;
            int count;
            HeapNode left;
            HeapNode right;

            public HeapNode(int val) {
                this.val = val;
            }
        }

        List<HeapNode> elems;
        public BinaryHeap(List<HeapNode> elems){
            this.elems = elems;
            buildHeap();
        }
        private void buildHeap(){

            for(int i = 0 ; i <= elems.size()/2;i++){
                if(2 * i + 1 < elems.size()){
                    elems.get(i).left = elems.get(2*i+1);
                }
                if(2 * i + 2 < elems.size()){
                    elems.get(i).right = elems.get(2*i+2);
                }
            }

            minifyHeap();
        }

        public void insert(int elem){

            elems.add(new HeapNode(elem));
            minifyHeap();

        }

        public int  extractMin(){
            int min = elems.get(0).val;
            elems.set(0 , elems.get(elems.size() - 1));
            elems.remove(elems.size()-1);
            minifyHeap();
            return min;
        }

        public int peekMin(){return elems.get(0).val;}

        private void minifyHeap(){
            for(int i = elems.size()- 1 ; i >= 0 ; i--){
                if(elems.get(i).val < elems.get(i/2).val){
                    HeapNode temp = new HeapNode(elems.get(i).val);
                    elems.set(i , elems.get(i/2));
                    elems.set(i/2 , temp);
                }
            }
        }


        public static void main(String[] args){

            Random random = new Random();
            List<HeapNode> heapNodes = new ArrayList<>();
            for(int i = 0 ; i < 20;i++) {
                heapNodes.add(new HeapNode(random.nextInt(30)));
            }
            BinaryHeap ourHeap = new BinaryHeap(heapNodes);
        }
    }

