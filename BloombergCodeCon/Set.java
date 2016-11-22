package BloombergCodeCon;

import java.util.*;
import java.util.stream.Collector;

//Your submission should *ONLY* use the following class name
public class Set
{
    public static void main(String[] args)
    {

        Scanner stdin = new Scanner(System.in);
        int num = stdin.nextInt();
        HashSet<Character> set = new HashSet<>();
        TreeMap<Character,ArrayList<Integer>> map = new TreeMap<>();
        while(num >0)
        {
            System.out.println("num is: "+num);
            String s = stdin.nextLine();
            if(s == null || s.length()==0) continue;
            System.out.println("string is: "+s);
            if(s.charAt(0) == '^'){

                    set.add(s.charAt(1));
                   if(!map.containsKey(s.charAt(1)))
                    map.put(s.charAt(1),new ArrayList<>());

            }
            else if(s.charAt(0) == '/'){
                    set.remove(s.charAt(1));
            }
            else{
                for(Character c:set){
                        ArrayList<Integer> al = map.get(c);
                        al.add(Integer.parseInt(s));
                        map.put(c,al);
                }
            }
            num--;
        }

        for(Character c:map.keySet()){
            System.out.print(c+ " ");
            ArrayList<Integer> temp = map.get(c);
            Collections.sort(temp);
            for(Integer numb:temp){
                System.out.print(numb+" ");
            }
            System.out.println();
        }
        stdin.close();
    }

}
