import java.rmi.*;

public interface CellPhoneService extends Remote
{
	public void calculateTime(int start, int end, String user) throws RemoteException;
}
