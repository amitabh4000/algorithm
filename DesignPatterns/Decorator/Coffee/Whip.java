package DesignPatterns.Decorator.Coffee;

/**
 * Created by SAmitabh on 12-11-2016.
 */
public class Whip extends Beverage {

    private double price = 0.3;
    Beverage beverage;
    public Whip(Beverage beverage){
          this.beverage = beverage;
    }

    public String getDescription(){
         return beverage.getDescription() +",with Whip";
    }
    public  double cost(){
       return price + beverage.cost();
    }

}
