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
		
		CellRecord one = new CellRecord(5, 10, "Joe");
		CellRecord two = new CellRecord(7, 12, "Nick");
		CellRecord three = new CellRecord(10, 25, "EWU CS");
		one = server.calculateTime(one);
		two = server.calculateTime(two);
		three = server.calculateTime(three);
		one.setEndTime(40);
		one.setStartTime(26);
		one = server.calculateTime(one);
		one.printRecord();
		two.printRecord();
		three.printRecord();
		
	}

}
