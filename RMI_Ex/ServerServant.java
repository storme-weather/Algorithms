import java.rmi.*;
import java.rmi.server.*;
import java.util.LinkedList;
import java.util.Vector;

@SuppressWarnings("serial")
public class ServerServant extends UnicastRemoteObject implements ServerInterface{
	LinkedList<Client> clients = new LinkedList<Client>();
	Vector<Client> callbackObjects = new Vector<Client>();
	
	protected ServerServant() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String generateId() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String sayHelloToClient() throws RemoteException {
		return "Hello World!";
	}

	@Override
	public String register(Client client) throws RemoteException {
		//This should guarantee an unique id
		client.id = client.name + System.currentTimeMillis();
		clients.add(client);
		return client.id;
	}

	@Override
	public void addCallback(Client client) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Got a callback call");
		callbackObjects.add(client);
	}

}
