/**
 * Created by SAmitabh on 31-08-2016.
 */
/**
 * Created by SAmitabh on 31-08-2016.
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class missingNumber {

    public static void main(String[] args) {


        Charset utf8 = StandardCharsets.UTF_8;
        try {
            List<String> lines = Files.readAllLines(Paths.get(args[0]));
            int count = Integer.parseInt(lines.get(0));

            String[] input = new String[count];
            List<String> output = new ArrayList<>();
            for(int i = 1 ; i < count+1;i++){

                String[] tokens = lines.get(i).split(" ");
                int[] numbers = new int[tokens.length];
                int smallest = Integer.MAX_VALUE;
                int largest = Integer.MIN_VALUE;

                for(int j = 0 ; j < tokens.length;j++){
                    numbers[j] = Integer.parseInt(tokens[j]);
                    smallest = Math.min(smallest, numbers[j]);
                    largest = Math.max(largest , numbers[j]);
                }
                System.out.println("Smallest: "+smallest+" largest: "+largest);
                boolean[] val = new boolean[largest - smallest +1];
                for(int j = 0 ; j < numbers.length ;j++){
                    val[numbers[j]- smallest] = true;
                }
                StringBuilder sb = new StringBuilder();
                for(int j = 0 ; j < val.length;j++){
                    if(!val[j]){
                        sb.append(j+smallest).append(" ");
                    }
                }

                output.add(sb.toString());
            }

            Files.write(Paths.get("file2.txt"), output,utf8);
        }
        catch(IOException e){
            System.out.println("Error in reading file: "+e);
        }


    }
}

