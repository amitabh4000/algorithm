package ElementsofPI.DP;

/**
 * Created by SAmitabh on 10-11-2016.
 */
public class searchSequence2d {
    static boolean flag = false;
    public static boolean search(int[][] maze , int[] seq){

        boolean[][] attemptFailed = new boolean[maze.length][maze[0].length];
        for(int i = 0; i < maze.length; i++){
            for(int j = 0; j < maze[0].length ; j++){
                if( maze[i][j] == seq[0]){
                    if(dfsHelper(attemptFailed, maze,seq,0,i,j)) return true;
                }
            }
        }
        return false;
    }


    public static boolean dfsHelper(boolean[][] attemptFailed , int[][] maze,int[] seq, int seqInd,int x,int y){

        if(seq.length -1 == seqInd){
            System.out.println("Inside found");
            return true;
        }
        final int[][] DIRS = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int[] dir:DIRS){
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if(nextX  >= 0 && nextX < maze.length
                    && nextY >= 0 && nextY < maze[0].length
                    && seq[seqInd+1] == maze[nextX][nextY]
                    && !attemptFailed[nextX][nextY]){
                    return(dfsHelper(attemptFailed,maze,seq,seqInd+1,nextX,nextY));
            }
        }
        attemptFailed[x][y] = true;
        return false;
    }


    public static void main(String[] args){

          int[][] maze = {{1,2,3},{3,4,5},{5,6,7}};
          int[] seq = {1,2,4,2,1,2,6,5};
        System.out.println(search(maze,seq));

    }

}
