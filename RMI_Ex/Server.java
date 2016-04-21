import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject{
	protected Server() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String args[])
	{
		try {
			//Naming.rebind("Attempt", new ServerServant());
			ServerServant ss = new ServerServant();
			Registry reg = LocateRegistry.createRegistry(7777);
			//reg.rebind("CallbackClient", exportObject(ss, 0));
			reg.re
			
			System.out.println("Server is ready!");
		} 
		catch(Exception e){
			System.out.println("Server failed: " + e);
		}
	}
}
