package DesignPatterns.ObserverObservable.WeatherData;

/**
 * Created by SAmitabh on 11-11-2016.
 */
public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}
