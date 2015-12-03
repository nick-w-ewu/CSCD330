import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class CellPhoneServer implements CellPhoneService
{
	private ArrayList<CellRecord> records;
	
	public CellPhoneServer() throws RemoteException
	{
		super();
		records = new ArrayList<CellRecord>();
	}
	
	@Override
	public void calculateTime(int start, int end, String name)
	{
		int newTime;
		int time;
		CellRecord i;
		for(int ix = 0; ix < records.size(); ix++)
		{
			i = records.get(ix);
			if(i.getID().equals(name))
			{
				time =  end - start;
				newTime = time + i.getTotalTime();
				i.setTotalTime(newTime);
				i.printRecord();
				return;
			}
		} 
		time = end - start;
		CellRecord cell = new CellRecord(start, end, name);
		cell.setTotalTime(time);
		records.add(cell);
		cell.printRecord();
	}
	
	
    public static void main(String args[]) {
        
        try {
            CellPhoneServer obj = new CellPhoneServer();
            CellPhoneService stub = (CellPhoneService) UnicastRemoteObject.exportObject(obj, 20009);

            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("CellPhoneService", stub);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }

}
