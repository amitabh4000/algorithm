package DesignPatterns.Behaviour;

/**
 * Created by SAmitabh on 09-11-2016.
 */
public abstract class Duck {


    ///  Interface and the classes which implements it ////
    public interface Quackbehaviour{
        void quack();
    }
    public class Quack implements Quackbehaviour{
        public void quack(){
            System.out.println("Quack quack");
        }
    }

    Quackbehaviour quackbehaviour;

    public void swim(){
        System.out.println("All ducks swim");
    }
    public void performquack(){
           quackbehaviour.quack();
    }
}
