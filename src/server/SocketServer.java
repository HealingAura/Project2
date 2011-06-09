package server;

import java.net.*;
import java.io.*;

public class SocketServer
{
    public static void main(String[] args) throws IOException
    {
        ServerSocket serverSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        try
        {
	  serverSocket = new ServerSocket(4444);
	  System.out.println("Server started");
        }
        catch (IOException e)
        {
	  System.err.println("Cannot listen on port 4444");
	  System.exit(-1);
        }
        Socket clientSocket = null;
        try
        {
	  clientSocket = serverSocket.accept();
	  out = new PrintWriter(clientSocket.getOutputStream(), true);
	  in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	  // server code here...
	  MyProtocol mp = new MyProtocol(in, out);
	  mp.run();
        }
        catch (IOException e)
        {
	  System.err.println("Accept failed");
	  System.exit(-1);
        }
        finally
        {
	  if (clientSocket != null) clientSocket.close();
	  if (serverSocket != null) serverSocket.close();
        }
    }
}
