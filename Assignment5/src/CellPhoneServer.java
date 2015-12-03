import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class CellPhoneServer implements CellPhoneService
{
	public CellPhoneServer() throws RemoteException
	{
		super();
	}
	
	@Override
	public CellRecord calculateTime(CellRecord record)
	{
		System.out.println("Processing record for " + record.getID());
		int time =  record.getEndTime() - record.getStartTime();
		int newTime = time + record.getTotalTime();
		record.setTotalTime(newTime);
		return record;
	}
	
    public static void main(String args[]) {
        
        try {
            CellPhoneServer obj = new CellPhoneServer();
            CellPhoneService stub = (CellPhoneService) UnicastRemoteObject.exportObject(obj, 20002);

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
