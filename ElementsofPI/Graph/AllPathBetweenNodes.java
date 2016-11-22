package ElementsofPI.Graph;

import java.util.*;
public class AllPathBetweenNodes {


    static List<List<GraphVertex>> big_list = new ArrayList<>();

    public static class GraphVertex{

        int val;
        List<GraphVertex> edges;

        public GraphVertex(int val){

            this.val = val;
            edges = new ArrayList<GraphVertex>();
        }

    }

    public static void findPath(List<GraphVertex> graph , GraphVertex a , GraphVertex b){



        List<GraphVertex> list = new ArrayList<>();
        list.add(a);
        dfsHelper(graph , a , b , list);
    }

    public static void dfsHelper(List<GraphVertex> graph, GraphVertex curr,
                                 GraphVertex dest , List<GraphVertex> list){

        if(curr == dest){
            big_list.add(list);
            return;
        }
        for(GraphVertex next: curr.edges){

            List<GraphVertex> newList = new ArrayList<>();
            for(GraphVertex vertex:list){
                newList.add(vertex);
            }
            newList.add(next);
            dfsHelper(graph , next , dest , newList);
        }
    }
}
