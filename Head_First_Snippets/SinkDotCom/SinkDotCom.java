package Head_First_Snippets.SinkDotCom;

import java.util.*;
/**
 * Created by SAmitabh on 23-07-2016.
 */
public class SinkDotCom {

    int[][] cells;
    int count = 0;

    public SinkDotCom(int[][] cells){
        this.cells = cells;
    }

    public void startGame() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                if (cells[i][j] == 1) {
                    count++;
                }
            }
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Hit it: Two numbers from 1-5 : Hit a number more than 5 to break");
        while (true){

        int x = sc.nextInt();
            if(x > 5) break;
        int y = sc.nextInt();
          if(y>5) break;
        if (cells[x - 1][y - 1] == 1) {
            count--;
            if (count == 0)
                System.out.println("You have killed everyone");
            else
                System.out.printf("You just killed one %d remaining\n", count);
        } else {
            System.out.printf("No one died try again\n");
        }
    }


    }


}
