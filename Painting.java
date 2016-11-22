import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.*;
import java.io.*;
/**
 * Created by SAmitabh on 31-08-2016.
 */
public class Painting {


    public static void main(String[] args) {


        String[] colors = {"red","blue","yellow","blank"};
        List<String> lines = new ArrayList<String>();
        try {
             lines = Files.readAllLines(Paths.get(args[0]));
        }
        catch(IOException e){

        }
      String[] str = lines.get(0).split(" ");

    }
}
