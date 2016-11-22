package twitterBala;

import java.util.*;
public class TweetsSuggestion {

    public static Set<Integer> bestTweets( int[][] following , int[][] likes ,
                                         int userId,int minThreshold){

        Set<Integer> tweetSet = new HashSet<>();
        Set<Integer> followSet = new HashSet<>();
        for(int[] follows:following){
            if(follows[0] == userId) followSet.add(follows[1]);
        }
        HashMap <Integer , Integer> hm = new HashMap<>();
        for(int[] like:likes){
            if(followSet.contains(like[0])){
                if(!hm.containsKey(like[1])){
                    hm.put(like[1], 1);
                }
                else{
                    hm.put(like[1], hm.get(like[1])+1);
                }
                if(hm.get(like[1]) >= minThreshold){
                    tweetSet.add(like[1]);
                }
            }
        }
        return tweetSet;
    }


    public static void main(String[] args){

        int[][] follower ={{1,2},{1,3},{1,4},{5,6}};
        int[][] likes = {{2,10},{3,10},{4,10},{2,11},{3,12},{4,11}};
        int threshold = 0;
        int userId = 1;
        Set<Integer> retList = bestTweets(follower,likes,userId,threshold);
        for(Integer num:retList){
            System.out.println("{");
            System.out.println(num+",");
            System.out.println("}");
        }


    }
}
