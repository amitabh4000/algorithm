package DesignPatterns.CommandObjects.MasterRemote;



public class AC {

    private boolean powerOn;
    AC(){
        powerOn = false;
    }

    public void turnOff(){
        powerOn = false;
    }

    public void turnOn(){
        powerOn = true;
    }

    public boolean getOnOrOff(){return powerOn;}

}
