package ElementsofPI.recursion;

import java.util.*;

// maxDiameter in a non-binary tree
public class maxDiameter {

    public static class TreeNode {List <Edge> edges = new ArrayList<>();}
    public static class Edge{
        TreeNode root;
        int length;
        public Edge(TreeNode root, int length){
            this.root = root;
            this.length = length;
        }
    }

    public static class HeightAndDiam{
        int height;
        int diameter;
        public HeightAndDiam(int height , int diameter){
            this.height = height;
            this.diameter = diameter;
        }
    }

    public static int maxDiam(TreeNode r){

        return maxHelper(r).diameter;
    }
    public static HeightAndDiam maxHelper(TreeNode r){


        int diam=0;
        int[] h = new int[2];
        for(Edge edge:r.edges){
            HeightAndDiam hd = maxHelper(edge.root);
            if(hd.height + edge.length > h[0]){
                h[1] = h[0];
                h[0] = hd.height + edge.length;
            }
            else if(hd.height + edge.length > h[1]){
                h[1] = hd.height + edge.length;
            }
            diam = Math.max(diam,hd.diameter);
        }

        return new HeightAndDiam(h[0],Math.max(h[0]+h[1],diam));

    }
}
