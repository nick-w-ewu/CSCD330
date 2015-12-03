import java.rmi.*;

public interface CellPhoneService extends Remote
{
	public CellRecord calculateTime(CellRecord record) throws RemoteException;
}
