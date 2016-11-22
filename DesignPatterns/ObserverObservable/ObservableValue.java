package DesignPatterns.ObserverObservable;
import java.util.*;


public class ObservableValue extends Observable {

    private int n =0;
    public ObservableValue( int n){
        this.n = n;
    }
    public void setValue(int n){
        this.n = n;
        setChanged();     /// These two are defined in the Observable class
        notifyObservers();
    }

    public int getValue(){
        return n;
    }


}
