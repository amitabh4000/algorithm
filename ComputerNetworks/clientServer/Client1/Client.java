package ComputerNetworks.clientServer.Client1;
import java.util.*;
import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.net.*;

public class Client {

    Socket cSocket;
    ObjectOutputStream out;
    ObjectInputStream in;
    String message;
    String MESSAGE;
    public void Client(){}
    void runServer(){
        try {
            // create a new socket to request the server
            cSocket = new Socket("Localhost", 8000);

                // Initialize input and output streams
            try {
                out = new ObjectOutputStream(cSocket.getOutputStream());
                in = new ObjectInputStream(cSocket.getInputStream());
                while(true){
                    try {
                        String message = (String) in.readObject();
                    }
                    catch(ClassNotFoundException error){
                        System.out.println("Input format not found..");
                    }
                }
            }
            catch(IOException ioe){
                ioe.printStackTrace();
            }
            finally{
                try {
                    in.close();
                    out.close();
                    cSocket.close();
                }
                catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
        catch(IOException e){

        }
    }
    /// Send a message to the output stream
    void sendMessage(String MESSAGE){
        try{
            out.writeObject(MESSAGE);
            out.flush();
            System.out.println("Sending message "+MESSAGE);
        }
        catch(IOException ioException){
            ioException.printStackTrace();
        }
    }

}
