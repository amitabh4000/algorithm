package DesignPatterns.ObserverObservable.WeatherData;

/**
 * Created by SAmitabh on 11-11-2016.
 */
public class CurrentCondDisplay  implements Observer,displayElement {


    private float temperature;
    private float humidity;
    private Subject  weatherData;

    public CurrentCondDisplay(Subject weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }


    public void update(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }


    public void display(){
         System.out.println("Current conditions: "+temperature+"F degrees and humidity: "+humidity +"%");
    }

}
