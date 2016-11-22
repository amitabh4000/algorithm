package DesignPatterns.Behaviour;

/**
 * Created by SAmitabh on 09-11-2016.
 */
public class RedHeadDuck extends Duck {
       public RedHeadDuck(){
           quackbehaviour = new Quack();
       }
       public void quack(){
           super.performquack();
       }
       public static void main(String[] args){

           RedHeadDuck rd = new RedHeadDuck();
           rd.quack();
       }

}
