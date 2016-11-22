/**
 * Created by SAmitabh on 31-08-2016.
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class characterMatch {

    public static void main(String[] args) {


        Charset utf8 = StandardCharsets.UTF_8;
        try {
            List<String> lines = Files.readAllLines(Paths.get(args[0]));
            int count = Integer.parseInt(lines.get(0));
            String[] input = new String[count];
            List<String> output = new ArrayList<>();
            for(int i = 1 ; i < lines.size();i++){
                boolean[] bitArray = new boolean[100];
                String[] tokens = lines.get(i).split(" ");

                for(int k = 0 ;k < tokens.length;k++) {
                    String s = tokens[k];
                    boolean[] tempBit = new boolean[100];
                    if (k == 0) {
                        for (int j = 0; j < s.length(); j++) {
                            int ind = s.charAt(j) - '0';
                            bitArray[ind] = true;
                        }
                    } else {
                        for (int j = 0; j < s.length(); j++) {
                            int ind = s.charAt(j) - '0';
                            tempBit[ind] = true;
                        }
                        for(int j = 0 ; j < 100 ; j++){
                            bitArray[j] &= tempBit[j];
                        }
                    }
                }
                StringBuilder sb = new StringBuilder();
                for(int a = 0 ; a < 100 ;a++){
                    if(bitArray[a]){
                        sb.append((char) (a+'0'));
                    }
                }
                output.add(sb.toString());
            }

            Files.write(Paths.get("file1.txt"), output,utf8);
        }
        catch(IOException e){
            System.out.println("Error in reading file: "+e);
        }


    }
}
