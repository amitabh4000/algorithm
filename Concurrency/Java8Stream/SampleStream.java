package Concurrency.Java8Stream;

import java.util.*;
public class SampleStream {
    public static class Name{
        private String name;
        private Name(String name){
            this.name = name;
        }
        public String getName(){
            return name;
        }
    }

    public static void main(String[] args){

        List<Name> list = new ArrayList<>();
        list.add(new Name("amitabh"));
        list.add(new Name("ashu"));
        list.add(new Name("eeee"));
        list.stream()
                .filter(r -> r.getName().startsWith("a"))
                .forEach(r -> System.out.println(r.getName()));
        String a = "hghgh";
    }
}
