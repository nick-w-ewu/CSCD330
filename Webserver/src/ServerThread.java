import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.StringTokenizer;

public class ServerThread extends Thread
{
	private Socket client;

	public ServerThread(Socket client)
	{
		this.client = client;
	}

	public void run()
	{
		try
		{
			BufferedReader recive = new BufferedReader
					(new InputStreamReader(this.client.getInputStream()));
			String message = recive.readLine();
			StringTokenizer token = new StringTokenizer(message);
			if(token.nextToken().equalsIgnoreCase("GET"))
			{
				PrintWriter send = new PrintWriter(this.client.getOutputStream(), true);
				send.println("HTTP/1.0 200 OK\r\n Content-Type: text/html\r\n\r\n" + 
						"<html><head></head><body>Hello</body></html>\n");
			}
			this.client.close();
		} 
		catch (Exception e)
		{

		} 

	}
}
