
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient2
{

	public static void main(String[] args) 
	{
		String host = "10.104.137.63";
		int port = 9090;
		
		try
		{
			Socket server = new Socket(host, port);
			PrintWriter send = new PrintWriter(server.getOutputStream(), true);
			ChatThread reciver = new ChatThread(server);
			reciver.start();
			Scanner input = new Scanner(System.in);
			
			String message = "running";
			while(!message.equals("Bye"))
			{
				message = input.nextLine();
				send.println(message);
			}
			reciver.requestStop();
			send.close();
			server.close();
		}
		catch(Exception e)
		{
			System.out.println("Connection failed");
		}
	}
	
}
