package DesignPatterns.ObserverObservable;

/**
 * Created by SAmitabh on 11-11-2016.
 */
public class Main {


    public Main() {
        ObservableValue ov = new ObservableValue(0);
        TextObserver to = new TextObserver(ov);
        ov.addObserver(to);
    }

    public static void main(String[] args){

        Main main = new Main();
    }


}
