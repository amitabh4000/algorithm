package Head_First_Snippets.SinkDotCom;

/**
 * Created by SAmitabh on 23-07-2016.
 */
public class Sinkdriver {

    int d = 2;

  public void india(){
      int c = 3;
      System.out.println("From superclass: "+c);
  }

    public static void main(String[] args){
        int[][] cells = new int[5][5];

        for( int i = 2; i<5 ;i++){
            cells[2][i] = 1;
        }
        for( int i = 1; i<3 ;i++){
            cells[i][1] = 1;
        }
        for( int i = 3; i<5 ;i++){
            cells[i][i] = 1;
        }
        SinkDotCom sink1 = new SinkDotCom(cells);
        sink1.startGame();
    }

    }



