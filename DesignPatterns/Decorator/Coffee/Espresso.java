package DesignPatterns.Decorator.Coffee;

/**
 * Created by SAmitabh on 12-11-2016.
 */
public class Espresso extends Beverage{

    String description = "This is espresso";
    double price = 1.2;
    public String getDescription(){
        return description;
    }

    public double cost(){
       return price;
    }

}
