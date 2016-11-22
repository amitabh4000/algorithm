package EffectiveJava;

import java.util.*;

public class CISS_String {

    private final String s;

    public CISS_String(String s){
        this.s =s;
    }

    @Override
    public boolean equals(Object o){

        if(o instanceof String){
            System.out.println("Checking if equal, instance of String");
            return s.equalsIgnoreCase((String)o);
        }
        else if(o instanceof CISS_String){
            System.out.println("Checking if equal");
            return s.equalsIgnoreCase(((CISS_String)o).s);
        }
        return false;
    }

    public static void main(String[] args){

        CISS_String virtString = new CISS_String("abc");
        String s = new String("Abc");
        List<String> list = new ArrayList<>();
        list.add(s);

        System.out.println("List contains virtString: " + list.contains(virtString));
    }

}
