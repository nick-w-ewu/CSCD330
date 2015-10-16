import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread extends Thread
{
	private Socket destination;
	private volatile boolean stop = false;
	private PrintWriter send;
	
	public ServerThread(Socket client)
	{
		this.destination = client;
	}
	
	public void requestStop()
	{
		stop = true;
		try
		{
			destination.close();
			send.close();
		} catch (IOException e)
		{
			
		}
		
	}
	
	public void run()
	{
		try
		{
			send = new PrintWriter(destination.getOutputStream(), true);
			Scanner input = new Scanner(System.in);
			
			while(!stop)
			{
				send.println(input.nextLine());
			}
		} 
		catch (Exception e)
		{
			
		} 
		
	}
}
