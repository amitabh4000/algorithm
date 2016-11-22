

package ADS_Saurabh.FibonacciHeap;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.*;

public class PopularHashtag {

    Charset utf8 = StandardCharsets.UTF_8;
    static List<String> lines = new ArrayList<String>();
    HashMap<String , FibonacciHeap.FibonacciNode> nodeMap;
    List<String> output = new ArrayList<String>();
    public static void main(String[] args){

        try {
            lines = Files.readAllLines(Paths.get(args[0]));
        }
        catch (IOException e) {

        }

        PopularHashtag popularHashtag = new PopularHashtag();
        FibonacciHeap fibonacciHeap = new FibonacciHeap(popularHashtag);
        popularHashtag.popularHashtag(lines, fibonacciHeap);
    }


    public void popularHashtag(List<String> lines, FibonacciHeap fibonacciHeap){

        nodeMap = new HashMap<>();
        for(String line:lines){
            if(line.contains("#")){
                String[] splitted = line.split(" ");
                String HashtagName = splitted[0].substring(1);
                int increaseCount = Integer.parseInt(splitted[1]);
                if(!nodeMap.containsKey(HashtagName)){
                    String newHashtagName = HashtagName;
                    FibonacciHeap.FibonacciNode node = new FibonacciHeap.FibonacciNode(HashtagName,increaseCount);
                    fibonacciHeap.insertNode(node);
                    nodeMap.put(newHashtagName , node);
                }
                else{
                    String pretrendingTag = HashtagName;
                    FibonacciHeap.FibonacciNode correspondingNode = nodeMap.get(HashtagName);
                    fibonacciHeap.increaseVal(correspondingNode, increaseCount);
                }
            }
            else if(line.contains("STOP")) {
                break;
            }
            else{
                int n = Integer.parseInt(line);
                //List<FibonacciNode> queryResult = fibonacciHeap.findPopularHashtags(n);

                List<FibonacciHeap.FibonacciNode> hashtagList = new ArrayList<>();
                for(int i = 0 ; i < n ; i++){
                    FibonacciHeap.FibonacciNode currMax = fibonacciHeap.extractMax();
                    hashtagList.add(currMax);
                }
                String finalOutput="";

                for(int i = 0 ; i < n ; i++){
                    FibonacciHeap.FibonacciNode newNode = new FibonacciHeap.FibonacciNode(hashtagList.get(i).key,hashtagList.get(i).value);
                    fibonacciHeap.insertNode(newNode);
                    nodeMap.remove(hashtagList.get(i).key);
                    finalOutput+=hashtagList.get(i).key+",";
                    nodeMap.put(hashtagList.get(i).key, newNode);
                }
                output.add(finalOutput);
                /*
                for(FibonacciNode node:queryResult){
                    System.out.print(node.key+node.value + (node != queryResult.get(queryResult.size()-1)? ",":" "));
                }
		*/
               // System.out.println();
            }

        }

        try {
            Files.write(Paths.get("Fill in the absolute path of the address you want the file to be written at/outputFile.txt"), output, utf8);
        }
        catch(IOException e){
            new IOException("File can't be written");
        }

    }
}