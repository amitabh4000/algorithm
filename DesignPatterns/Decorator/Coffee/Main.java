package DesignPatterns.Decorator.Coffee;

/**
 * Created by SAmitabh on 12-11-2016.
 */
public class Main {


    public static void main(String[] args){

        Beverage beverage1 = new Espresso();
        beverage1 = new Mocha(beverage1);
        beverage1 = new Mocha(beverage1);
        beverage1 = new Whip(beverage1);
        System.out.println(beverage1.getDescription());
    }
}
