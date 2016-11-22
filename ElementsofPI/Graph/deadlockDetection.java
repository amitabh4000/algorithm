package ElementsofPI.Graph;

import java.util.*;


public class deadlockDetection {

    public static class GraphVertex{

        public static enum Color {
            WHITE , GRAY , BLACK
        }
        public Color color;
        public List<GraphVertex> edges;
    }

    public static boolean isDeadlock(List<GraphVertex> list){

        for(GraphVertex curr:list){
            if(curr.color == GraphVertex.Color.WHITE ){

                if(hasCycle(curr,null)) return true;
            }
        }



        return false;
    }

    public static boolean hasCycle(GraphVertex curr,GraphVertex prev){

        if(curr.color == GraphVertex.Color.GRAY){
            return true;
        }
        for(GraphVertex next:curr.edges){

            if(next.color != GraphVertex.Color.BLACK && next != prev){
                if(hasCycle(next , curr)) return true;
            }

        }
        return false;
    }



}


