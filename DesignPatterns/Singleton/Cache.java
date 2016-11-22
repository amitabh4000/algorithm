package DesignPatterns.Singleton;

/*The basic concept is to make the constructor private,
  call it within the class and store it in a variable */

public class Cache {

    private int n;
    private static Cache cache;

    private Cache(){

    }

    public static synchronized Cache  getInstance(){
        if(cache == null){
           cache = new Cache();
        }
        return cache;
    }

    public void setVal(int n){
        this.n = n;
    }

    public int getVal(){
        return n;
    }

}
