//package ComputerNetworks.clientServer;
//
//import java.util.*;
//import java.io.*;
//import java.nio.*;
//import java.nio.channels.*;
//import java.net.*;
//
//public class Server {
//
//    int sPort = 8000;
//    ServerSocket sSocket;
//    Socket connection = null;
//    String message;
//    String MESSAGE;
//    ObjectOutputStream out;
//    ObjectInputStream in;
//
//    public class Worker implements Runnable{
//
//        Socket cSocket;
//        int clientNo;
//        private Worker(Socket cSocket , int clientNo){
//            this.clientNo = clientNo;
//            this.cSocket = cSocket;
//        }
//        @Override
//        public void run() {
//            try {
//                out = new ObjectOutputStream(cSocket.getOutputStream());
//                in  = new ObjectInputStream(cSocket.getInputStream());
//                while(true){
//                    try {
//                        String message = (String) in.readObject();
//                    }
//                    catch(ClassNotFoundException error){
//                        System.out.println("Input format not found..");
//                    }
//                }
//            }
//            catch(IOException ioe){
//
//            }
//            finally{
//                try {
//                    in.close();
//                    out.close();
//                    cSocket.close();
//                }
//                catch(IOException e){
//
//                }
//            }
//        }
//    }
//    void runServer(){
//        try {
//            // create a new socket
//            sSocket = new ServerSocket(sPort, 10);
//            // Waiting for connection
//            System.out.println("Waiting for connection");
//            // Accept a connection from client
//            int clientNo =0;
//            while (true) {
//                connection = sSocket.accept();
//                System.out.println("Connection received from " +
//                        connection.getInetAddress().getHostName());
//                // Initialize input and output streams
//                new Thread(new Worker(connection , ++clientNo)).start();
//            }
//        }
//        catch(IOException e){
//
//        }
//        finally{
//            sSocket.close();
//        }
//    }
//    /// Send a message to the output stream
//    void sendMessage(String MESSAGE){
//        try{
//            out.writeObject(MESSAGE);
//            out.flush();
//            System.out.println("Sending message "+MESSAGE);
//        }
//        catch(IOException ioException){
//            ioException.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args){
//
//        Server server = new Server();
//        server.runServer();
//    }
//
//}
