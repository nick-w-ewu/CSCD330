import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CellPhoneClient
{

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException
	{
		Registry registry = LocateRegistry.getRegistry("localhost");
        CellPhoneService server = (CellPhoneService) registry.lookup("CellPhoneService");
		
		server.calculateTime(5, 10, "Joe");
		server.calculateTime(7, 12, "Nick");
		server.calculateTime(10, 25, "EWU CS");
		server.calculateTime(26, 40, "Joe");
		
	}

}
