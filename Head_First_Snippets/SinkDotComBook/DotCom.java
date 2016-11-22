package Head_First_Snippets.SinkDotComBook;


import java.util.*;
import java.io.*;
public class DotCom {

    private ArrayList <String> locationCells;
    private String name;


    public void setLocationCells(ArrayList<String> locs){
        locationCells = locs;
    }

    public void setName(String name){
        this.name = name;
    }

    public String checkYouself(String userInput){

        String result ="miss";
        int index = locationCells.indexOf(userInput);

        if(index >= 0 ){
            locationCells.remove(index);
        }
        if(locationCells.isEmpty()){
            System.out.println("You sank "+name);
            result = "kill";
        }
        else{

            result = "hit";
        }
        return result;
    }

}
