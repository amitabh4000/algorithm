package DesignPatterns.Decorator.Coffee;

/**
 * Created by SAmitabh on 12-11-2016.
 */
public abstract class Beverage {


    String description = "This is an unnamed beverage";
    public abstract String getDescription();
    public abstract double cost();

}
