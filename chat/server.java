

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class server extends UnicastRemoteObject implements serverInterface{
	ArrayList<Client> list = new ArrayList<Client>();

	private static final long serialVersionUID = 1L;

	protected server() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public synchronized void register(Client client) throws RemoteException {
		// TODO Auto-generated method stub
		list.add(client);
	}

	@Override
	public synchronized void message(String message) throws RemoteException {
		// TODO Auto-generated method stub
		int i = 0;
		while (i < list.size()) list.get(i++).retrieve(message);
	}
}