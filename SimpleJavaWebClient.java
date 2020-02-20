import java.net.*;
import java.io.*;
import java.util.Arrays;

public class SimpleJavaWebClient{

   public static void main(String [] args) {
      String serverName = args[0];
      int port = Integer.parseInt(args[1]);
      try {
         System.out.println("Connecting to " + serverName + " on port " + port);
         Socket client = new Socket(serverName, port);
         
         System.out.println("Just connected to " + client.getRemoteSocketAddress());
         OutputStream outToServer = client.getOutputStream();
         DataOutputStream out = new DataOutputStream(outToServer);
         
         out.writeUTF("GET /index.html HTTP/1.1");
         InputStream inFromServer = client.getInputStream();
         DataInputStream in = new DataInputStream(inFromServer);
         byte[] content=new byte[in.available()];
        in.read(content);
        String result=new String(content);
        System.out.println("Server says "+result);
         client.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}