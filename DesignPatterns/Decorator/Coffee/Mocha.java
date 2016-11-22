package DesignPatterns.Decorator.Coffee;

/**
 * Created by SAmitabh on 12-11-2016.
 */
public class Mocha extends DecoratorBev{

    private String description = "This is a mocha";
    private double price = 0.4;
    Beverage beverage;
    public Mocha(Beverage beverage){
        this.beverage = beverage;
    }
    public String getDescription(){

     return beverage.getDescription()+" with Mocha,";
    }
    public double cost(){
       return price + beverage.cost();
    }

}


