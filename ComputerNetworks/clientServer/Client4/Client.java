package ComputerNetworks.clientServer.Client4;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {

    Socket cSocket;
    ObjectOutputStream out;
    ObjectInputStream in;
    String message;
    String MESSAGE;
    public void Client(){}
    void run(){

        // Create a new clientSocket
        cSocket = new Socket();
    }

}
