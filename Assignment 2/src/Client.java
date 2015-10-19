import java.net.Socket;

public class Client
{
	public Socket socket;
	public ServerThread clientThread;
	public int clientNum;
	
	public Client(Socket socket, ServerThread thread, int num)
	{
		this.socket = socket;
		this.clientThread = thread;
		this.clientNum = num;
	}
}
