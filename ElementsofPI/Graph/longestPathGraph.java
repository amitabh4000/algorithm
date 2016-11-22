//package ElementsofPI.Graph;
//
//import java.util.*;
//
//
//public class longestPathGraph {
//
//    public static class GraphNode{
//        int maxDistance;
//        boolean visited
//        List<GraphNode> edges;
//        public GraphNode(){
//            maxDistance = 1;
//            visited = false;
//        }
//    }
//
//    public static int longestDistance(List<GraphNode> graph){
//
//        Deque<GraphNode> dq = buildTopology(graph);
//        return findDistance(dq);
//    }
//
//    public static Deque<GraphNode> buildTopology(List<GraphNode> graph){
//
//        Deque<GraphNode> dq = new LinkedList<>();
//        for(GraphNode vertex:graph){
//            if(!vertex.visited){
//                DFSBuilder(vertex, dq);
//            }
//        }
//        return dq;
//    }
//    public static void DFSBuilder(GraphNode vertex ,
//                                  Deque<GraphNode> dq){
//        vertex.visited = true;
//        for(GraphNode next:vertex.edges){
//
//            if(!next.visited){
//                DFSBuilder(next,dq);
//            }
//        }
//
//        dq.offerFirst(vertex);
//    }
//
//    public static int findDistance(Deque<GraphNode> dq){
//
//        int maxDistance = 0;
//        while(!dq.isEmpty()){
//
//
//        }
//
//
//    }
//
//
//}
