package ElementsofPI.Graph;

import java.util.*;

public class cloneGraph {

    public static class GraphVertex{

        int val;
        static List <GraphVertex> edges;

        public GraphVertex(int val){
            this.val = val;
            edges = new ArrayList<>();
        }
    }
    public GraphVertex cloneBFS( GraphVertex u){

        Queue<GraphVertex> queue = new LinkedList<>();
        HashMap<GraphVertex , GraphVertex> hm = new HashMap<>();
        GraphVertex uCopy = new GraphVertex(u.val);
        hm.put(u,uCopy);
        queue.offer(u);
        while(!queue.isEmpty()){
            GraphVertex curr = queue.poll();
            GraphVertex currCopy = hm.get(curr);
            for(GraphVertex next:curr.edges){
                GraphVertex nextCopy;
                if(!hm.containsKey(next)){
                    nextCopy = new GraphVertex(next.val);
                    hm.put(next,nextCopy);
                    queue.offer(next);
                }
                else{
                    nextCopy = hm.get(next);
                }
                currCopy.edges.add(nextCopy);
            }
        }
     return uCopy;
    }

    public GraphVertex cloneDFS( GraphVertex u){

        HashMap<GraphVertex , GraphVertex> hm = new HashMap<>();

        return dfsHelper(u , hm);
    }

    public static GraphVertex dfsHelper(GraphVertex g , HashMap<GraphVertex , GraphVertex> hm){

        if(hm.containsKey(g)) return null;
        GraphVertex gCopy = new GraphVertex(g.val);
        for(GraphVertex next:GraphVertex.edges){
            GraphVertex nextCopy;
            if(!hm.containsKey(next)){
                nextCopy = new GraphVertex(next.val);
                hm.put(next,nextCopy);
                dfsHelper(next,hm);
            }
            else{
                nextCopy = hm.get(next);
            }
            gCopy.edges.add(nextCopy);
        }

        return gCopy;
    }

}
