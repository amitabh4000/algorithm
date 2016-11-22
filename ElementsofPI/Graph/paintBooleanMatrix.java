package ElementsofPI.Graph;

import java.util.*;
public class paintBooleanMatrix {

    public static class Directions{
        int x;
        int y;
        public Directions(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void flipColor(List<List<Boolean>> maze, int x, int y) {

        boolean color = maze.get(x).get(y);
        maze.get(x).set(y, !maze.get(x).get(y));
        Queue<Directions> queue = new LinkedList<>();
        final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        queue.offer(new Directions(x,y));
        while (!queue.isEmpty()) {
            Directions curr = queue.poll();
            for (int[] dir : DIRS) {
                Directions next = new Directions(curr.x + dir[0], curr.y + dir[1]);
                if (next.x >= 0 && next.y >= 0 && next.x < maze.size()
                        && next.y < maze.get(x).size() && maze.get(next.x).get(next.y) == color) {

                    maze.get(next.x).set(next.y, !maze.get(next.x).get(next.y));
                    queue.offer(next);
                }
            }
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
            list3.add(true);
            list3.add(true);
            list3.add(true);
            list3.add(false);
            list3.add(false);
            bigList.add(list3);
        List<Boolean> list4 = new ArrayList<>();
            list4.add(true);
            list4.add(true);
            list4.add(true);
            list4.add(true);
            list4.add(false);
            bigList.add(list4);


        // Print the list before painting
        for(List<Boolean> list:bigList){
            for(Boolean val:list){
                System.out.print(val+" ");
            }
            System.out.println();
        }
        flipColor(bigList,2,3);
        System.out.println();
        // Print the list after painting
        for(List<Boolean> list:bigList){
            for(Boolean val:list){
                System.out.print(val + " ");
            }
            System.out.println();
        }

    }

}
