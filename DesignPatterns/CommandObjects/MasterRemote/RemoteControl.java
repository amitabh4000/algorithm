package DesignPatterns.CommandObjects.MasterRemote;


import java.util.HashMap;
import java.util.Map;

import java.util.*;

public class RemoteControl {

    Command[] onCommand;
    Command[] offCommand;
    Command undoCommand;

    RemoteControl(){
    }

    public void setCommand(int slot , Command onCommand, Command offCommand){

        this.onCommand[slot] = onCommand;
        this.offCommand[slot] = offCommand;
    }

    public void onButtonPressed(int slot){
           onCommand[slot].execute();
           undoCommand = onCommand[slot];
    }

    public void offButtonPressed(int slot){
           offCommand[slot].execute();
            undoCommand = onCommand[slot];
    }

    public void undoButtonPressed(int slot){
        undoCommand.execute();
    }


}
