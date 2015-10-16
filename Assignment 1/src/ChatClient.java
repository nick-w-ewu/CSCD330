import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient
{

	public static void main(String[] args) 
	{
		String host = "127.0.0.1";
		int port = 1236;
		
		try
		{
			Socket server = new Socket(host, port);
			PrintWriter send = new PrintWriter(server.getOutputStream(), true);
			BufferedReader recive = new BufferedReader
									(new InputStreamReader(server.getInputStream()));
			Scanner input = new Scanner(System.in);
			
			String message = "running";
			while(!message.equals("Bye"))
			{
				System.out.println(recive.readLine());
				message = input.nextLine();
				send.println(message);
			}
			send.close();
			recive.close();
			server.close();
		}
		catch(Exception e)
		{
			System.out.println("Connection failed");
		}
	}
	
}
