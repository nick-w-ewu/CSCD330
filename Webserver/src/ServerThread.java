import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread extends Thread
{
	private Socket client;
	private int index;
	private Client[] clients;

	public ServerThread(Socket client, int ix, Client[] clients)
	{
		this.client = client;
		this.index = ix;
		this.clients = clients;
	}



	public void run()
	{
		try
		{
			BufferedReader recive = new BufferedReader
					(new InputStreamReader(this.client.getInputStream()));
			String message = recive.readLine();
			PrintWriter send = new PrintWriter(clients[this.index].socket.getOutputStream(), true);
			send.println("HTTP/1.0 200 OK\r\n Content-Type: text/html\r\n\r\n" + 
							"<html><head></head><body>Hello</body></html>\n");
				
		} 
		catch (Exception e)
		{
			removeMe();
		} 

	}
	
	private synchronized void removeMe()
	{
		clients[this.index].setConnected(false);
	}
}
