import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer2
{

	public static void main(String[] args)
	{
		int port = 1235;
		String host = "127.0.0.1";
		try
		{
			ServerSocket server = new ServerSocket(port);
			Socket client = server.accept();
			ServerThread sender = new ServerThread(client);
			sender.start();
			BufferedReader recive = new BufferedReader
					(new InputStreamReader(client.getInputStream()));
			
			while(true)
			{
				try
				{
					String message = recive.readLine();
					System.out.println(message);
					if(message.equals("Bye"))
					{
						throw new IllegalAccessException();
					}
				}
				catch(Exception e)
				{
					sender.requestStop();
					System.out.println("Waiting for client");
					client = server.accept();
					recive = new BufferedReader
							(new InputStreamReader(client.getInputStream()));
					sender = new ServerThread(client);
					sender.start();
					System.out.println("Client Accepted");
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Server failure");
		}
	}

}