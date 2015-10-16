import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer
{

	public static void main(String[] args)
	{
		int port = 1236;
		String host = "127.0.0.1";
		try
		{
			ServerSocket server = new ServerSocket(port);
			Socket client = server.accept();
			PrintWriter send = new PrintWriter(client.getOutputStream(), true);
			BufferedReader recive = new BufferedReader
									(new InputStreamReader(client.getInputStream()));
			Scanner input = new Scanner(System.in);
			
			while(true)
			{
				try
				{
					send.println(input.nextLine());
					System.out.println(recive.readLine());
				}
				catch(Exception e)
				{
					System.out.println("Waiting for client");
					client = server.accept();
					send = new PrintWriter(client.getOutputStream(), true);
					recive = new BufferedReader
											(new InputStreamReader(client.getInputStream()));
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Server failure");
		}
	}

}
