import java.net.Socket;

public class Client
{
	public Socket socket;
	public ServerThread clientThread;
	
	public Client(Socket socket, ServerThread thread)
	{
		this.socket = socket;
		this.clientThread = thread;
	}
}
