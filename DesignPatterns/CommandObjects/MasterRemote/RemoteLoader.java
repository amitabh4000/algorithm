package DesignPatterns.CommandObjects.MasterRemote;


public class RemoteLoader {

    public static void main(String[] args){

        RemoteControl remote = new RemoteControl();
        AC ac = new AC();
        AC_ONCommand ac_oncomm = new AC_ONCommand(ac);

        Command[] onCommand = {ac_oncomm};
        Command[] offCommand = {ac_oncomm};
        MacroCommand onMCommand = new MacroCommand(onCommand);
        MacroCommand offMCommand = new MacroCommand(offCommand);

        remote.setCommand(0 , onMCommand, offMCommand);

    }


}
