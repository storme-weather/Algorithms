import java.rmi.*;

public interface ServerInterface extends Remote{
	public String generateId() throws RemoteException;
	public String sayHelloToClient() throws RemoteException;
	
	//Callback method
	public String register (Client client) throws RemoteException;
	public void addCallback(Client client) throws java.rmi.RemoteException;
}
