import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer
{

	public static void main(String[] args)
	{
		int port = 1237;
		
		try
		{
			ServerSocket server = new ServerSocket(port);
			Socket client;
			ServerThread clientThread;

			while(true)
			{
				try
				{
					client = server.accept();
					clientThread = new ServerThread(client);
					clientThread.start();

				}
				catch(Exception e)
				{
					System.out.println("Something went wrong");
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Server failure");

		}
	}


}