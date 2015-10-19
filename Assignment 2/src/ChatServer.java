import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer
{

	public static void main(String[] args)
	{
		int port = 1235;
		int clientNum = 1;
		Client[] clients = new Client[3];
		
		try
		{
			ServerSocket server = new ServerSocket(port);
			PrintWriter error;
			Socket client = server.accept();
			ServerThread sender = new ServerThread(client, 0, clients);
			int location;
			addClient(clients, client, sender, 0, clientNum);
			clientNum++;

			while(true)
			{
				try
				{
					client = server.accept();
					location = findSlot(clients);
					if(location != -1)
					{
						sender = new ServerThread(client, location, clients);
						addClient(clients, client, sender, location, clientNum);
						clientNum++;
					}
					else
					{
						error = new PrintWriter(client.getOutputStream(), true);
						error.println("Server Full");
						client.close();
					}

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

	private synchronized static int findSlot(Client[] clients)
	{
		for(int i = 0; i < clients.length; i++)
		{
			if(clients[i] == null)
			{
				return i;
			}
		}
		return -1;
	}

	private synchronized static void addClient(Client[] clients, Socket client, ServerThread sender, int i, int num)
	{
		clients[i] = new Client(client, sender, num);
		sender.start();
	}

}