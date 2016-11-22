package DesignPatterns.CommandObjects.MasterRemote;

public class AC_ONCommand implements Command {

    AC ac;
    boolean prevOnOrOff;
    AC_ONCommand(AC ac){
        this.ac = ac;
    }
    public void execute(){
          prevOnOrOff = ac.getOnOrOff();
          ac.turnOn();
    }
    public void undo(){
       if(!prevOnOrOff) ac.turnOff();
    }

}
