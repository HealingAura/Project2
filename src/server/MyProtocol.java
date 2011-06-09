package server;

import java.net.*;
import java.io.*;
import java.util.HashMap;

public class MyProtocol
{
    BufferedReader in;
    PrintWriter out;
    HashMap<String, String> hm;

    public MyProtocol(BufferedReader in, PrintWriter out)
    {
        this.in = in;
        this.out = out;
        hm = new HashMap<String, String>();
        hm.put("hello", "world!");
        hm.put("Alice", "Bob!");
        hm.put("Exit", "bye!");
    }

    public void run()
    {
        String request = "", response = "";
        try
        {
	  while (!request.startsWith("Exit"))
	  {
	      request = in.readLine();
	      response = hm.get(request);
	      if (response != null) out.println(response);
	      else out.println("?");
	  }
        }
        catch (IOException e)
        {
        }
    }
}
