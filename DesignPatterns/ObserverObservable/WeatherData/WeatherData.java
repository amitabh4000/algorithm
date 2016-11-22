package DesignPatterns.ObserverObservable.WeatherData;

import java.util.*;
public class WeatherData implements Subject{

    private float temperature;
    private float humidity;
    private float pressure;

    private List<Observer> list;   //// The knowledge required to create the list is that
                                   //// the observer class implements observer interface.

    public WeatherData(){
        list = new ArrayList<>();
    }

    public void registerObserver(Observer o){
          list.add(o);
    }

    public void notifyObservers(){
       for(Observer observer:list){
           observer.update(temperature,humidity,pressure);
       }
    }

    public void measurementsChanged(){
        notifyObservers();
    }

    public void setMeasurements(float humidity, float temperature,float pressure){

        this.humidity = humidity;
        this.temperature = temperature;
        this.pressure = pressure;
        measurementsChanged();
    }

    public void removeObserver(Observer o){
         int i = list.indexOf(o);
        if(i >=0){
            list.remove(i);
        }
    }



}
