package ElementsofPI.DP;

/**
 * Created by SAmitabh on 14-11-2016.
 */
public class USElection {


    public static boolean checkIfTie(int[] seats){

        int sum = 0;
        for(int seat:seats){
            sum += seat;
        }
        if((sum & 1) != 0){
            return false;
        }
        int seatForTie = sum/2;


        int[][] table = new int[seats.length][seatForTie+1];

        for(int i = 0; i < table.length ;i++){
            for(int j = 0 ; j < table[0].length; j++){

            }
        }


        return false;
    }



    public static void main(String[] args){


        int[] seats = {9,3,11,6,55,9,7,3,29,16,4,4,20,11,6,6,8,
                       8,4,10,11,16,10,6,10,3,5,6,4,14,5,29,15,3,
                        18,7,7,20,4,9,3,11,38,6,3,13,12,5,10,3,3};


        checkIfTie(seats);

    }

}
