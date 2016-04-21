

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface serverInterface extends Remote{
	void register(Client client) throws RemoteException;
	void message(String message) throws RemoteException;
}
