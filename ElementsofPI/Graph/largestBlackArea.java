package ElementsofPI.Graph;

import java.util.*;
public class largestBlackArea {

    public static class Directions{
        int x;
        int y;
        public Directions(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private static List<Directions> resultList = new ArrayList<>();
    private static void blackArea(List<List<Boolean>> maze){
            for (int  i = 0 ; i < maze.size(); i++){
                for(int j = 0 ; j < maze.get(i).size();j++){
                    if(maze.get(i).get(j) == false){
                        maze.get(i).set(j, !maze.get(i).get(j));
                        List<Directions> list = new ArrayList<>();
                        list.add(new Directions(i,j));
                        dfsHelper(maze , i , j, list);
                    }
                }
            }


    }
    private static void dfsHelper(List<List<Boolean>> maze , int x, int y, List<Directions> list){

        final int[][] DIRS = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int[] dir:DIRS){
            Directions next = new Directions(x+dir[0],y+dir[1]);
            if(next.x >= 0 && next.y >= 0
                    && next.x < maze.size() && next.y < maze.get(next.x).size()
                    && maze.get(next.x).get(next.y) == false){
                list.add(next);
                maze.get(next.x).set(next.y, !maze.get(next.x).get(next.y));
                dfsHelper(maze , next.x , next.y , list);
            }
        }
        if(list.size() > resultList.size()){
            resultList = list;
        }

    }

    public static void main(String[] args){

        List<List<Boolean>> bigList = new ArrayList<>();
        List<Boolean> list1 = new ArrayList<>();
        list1.add(true);
        list1.add(false);
        list1.add(true);
        list1.add(false);
        list1.add(true);
        bigList.add(list1);

        List<Boolean> list2 = new ArrayList<>();
        list2.add(false);
        list2.add(true);
        list2.add(false);
        list2.add(false);
        list2.add(false);
        bigList.add(list2);
        List<Boolean> list3 = new ArrayList<>();
        list3.add(false);
        list3.add(true);
        list3.add(true);
        list3.add(true);
        list3.add(false);
        bigList.add(list3);
        List<Boolean> list4 = new ArrayList<>();
        list4.add(false);
        list4.add(true);
        list4.add(true);
        list4.add(true);
        list4.add(false);
        bigList.add(list4);

        for(List<Boolean> list:bigList){
            for(Boolean val:list){
                System.out.print(val+" ");
            }
            System.out.println();
        }



        blackArea(bigList);
        // Print the points of the largest black area
        for(Directions point:resultList){

            System.out.print("(" + point.x + ","+point.y+");");
        }

    }

}
