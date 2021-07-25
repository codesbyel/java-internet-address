package serversocketclient;

import java.io.*;
import java.net.*;

public class CounterServer {
  public static void main(String[] args) throws Exception {
    try {
      ServerSocket server = new ServerSocket(8888);
      int counter = 0;
      System.out.println("Server is executed....loading: ");
      while (true) {
        counter++;
        Socket serverClientSocket = server.accept();
        System.out.println(" = " + "client number:" + counter + " start");
        ClientServerThread socket = new ClientServerThread(serverClientSocket, counter);
        socket.start();
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}

class ClientServerThread extends Thread {
  Socket serverClient;
  int squre;
  int clientCount;

  ClientServerThread(Socket inSocket, int counter) {
    serverClient = inSocket;
    clientCount = counter;
  }

  public void run() {
    try {
      DataInputStream inStream = new DataInputStream(serverClient.getInputStream());
      DataOutputStream outStream = new DataOutputStream(serverClient.getOutputStream());
      String clientMessage = "", serverMessage = "";
      while (!clientMessage.equals("bye")) {
        clientMessage = inStream.readUTF();
        System.out.println("From Client-" + clientCount + ": Number is :" + clientMessage);
        squre = Integer.parseInt(clientMessage) * Integer.parseInt(clientMessage);
        serverMessage = "From Server to Client-" + clientCount + " Square of " + clientMessage + " is " + squre;
        outStream.writeUTF(serverMessage);
        outStream.flush();
      }
      inStream.close();
      outStream.close();
      serverClient.close();
    } catch (Exception ex) {
      System.out.println(ex);
    } finally {
      System.out.println("Client -" + clientCount + " exit!! ");
    }
  }
}