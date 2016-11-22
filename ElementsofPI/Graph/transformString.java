package ElementsofPI.Graph;

import java.util.*;
public class transformString {

    public static class GraphString {
        String val;
        List<String> path;

        public GraphString(String val){
            this.val = val;
            path = new ArrayList<>();
        }
    }

    public static List<String> transformString(HashSet<String> dict ,String a, String b){

        if(! dict.contains(a) || !dict.contains(b)) return null;
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Queue<GraphString> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        GraphString aVertex = new GraphString(a);
        aVertex.path.add(a);
        queue.add(aVertex);

        while(!queue.isEmpty()){
            GraphString curr = queue.poll();
            if(b.equals(curr.val)){
                return curr.path;
            }
            int diff = findDiff(curr.val , b);
            for(int i = 0 ; i < curr.val.length(); i++){

                String start = i == 0 ? "":curr.val.substring(0,i);
                String end = i == curr.val.length()-1 ? "":curr.val.substring(i+1);

                for(int j = 0 ; j < alphabet.length(); j++){
                    String next = start + alphabet.charAt(j) + end;
                    if(!visited.contains(next) && dict.contains(next) && findDiff(next,b) == diff-1){
                        visited.add(next);
                        GraphString newNode = new GraphString(next);
                        List<String> newList = new ArrayList<>();
                        for(String string:curr.path){
                            newList.add(string);
                        }
                        newList.add(next);
                        newNode.path = newList;
                        queue.add(newNode);
                    }
                }
            }

        }

        return null;
    }

    public static int findDiff(String a , String b){

        if(a.length() != b.length()) return 0;
        int count = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args){

        HashSet<String> dict = new HashSet<>();
        dict.add("cat");
        dict.add("cot");
        dict.add("dog");
        dict.add("dag");
        dict.add("dot");
        dict.add("cat");
        List<String> list = transformString(dict ,"cat","dog");
        for(String string:list){
            System.out.print(string+ ",");
        }
    }

}
