package ElementsofPI.Graph;

import java.util.*;


public class enclosedRegion {

    public static void enclosedRegion(char[][] board){

        int n = board.length;
        int m = board[0].length;


        boolean[][] visited = new boolean[n][m];
        for(int i = 0 ; i < n ; i++) {
            if (board[i][0] == 'W' && !visited[i][0]) {
                visited[i][0] = true;
                bfsHelper(board, visited, i, 0);
            }
            if (board[i][m - 1] == 'W' && !visited[i][m - 1]){
            visited[i][m - 1] = true;
            bfsHelper(board, visited, i, m - 1);
        }
        }

        for (int j = 0 ; j < board[0].length; j++){

            if(board[0][j] == 'W' && !visited[0][j]){
                visited[0][j] = true;
                bfsHelper(board,visited,0,j);
            }
            if(board[n-1][j] == 'W' && !visited[n-1][j]){
                visited[n-1][j] = true;
                bfsHelper(board,visited,n-1,j);
            }

        }

        for(int i = 1 ; i < n-1; i++){
            for(int j = 1 ; j < m-1 ; j++){

                if(board[i][j] == 'W' && !visited[i][j]){
                    board[i][j] = 'B';
                }
            }
        }
    }

    static class Directions{
        int x;
        int y;
        Directions(int x , int y){
            this.x = x;
            this.y = y;
        }
    }

    static void bfsHelper(char[][] board, boolean[][] visited , int x , int y){

        final int[][] DIRS = {{0,1},{0,-1},{1,0},{-1,0}};
        Queue<Directions> queue = new LinkedList<>();
        queue.offer(new Directions(x,y));
        while(!queue.isEmpty()){
            Directions curr = queue.poll();
            for(int[] dir:DIRS){
                Directions next = new Directions(curr.x+dir[0],curr.y+dir[1]);
                if(next.x >=0 && next.y >=0
                        && next.x < board.length && next.y < board[next.x].length
                        && board[next.x][next.y] == 'W'
                        && !visited[next.x][next.y]){
                           queue.offer(next);
                           visited[next.x][next.y] = true;
                }
            }
        }
    }


    public static void main(String[] args){

       char[][] board = {{'B','W','B','W'},{'W','B','W','B'},{'B','B','B','W'},{'B','W','B','W'}};

        for(char[] arr:board){
            for(char val:arr){
                System.out.print(val+" ");
            }
            System.out.println();
        }


        System.out.println();
       enclosedRegion(board);
        // Print the points of the largest black area
        for(char[] arr:board){
            for(char val:arr){
                System.out.print(val+" ");
            }
            System.out.println();
        }

    }
}
