import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.*;

public class Client implements ClientCallbackInterface{
	public int x_location;
	public int y_location;
	public String name;
	public int age;
	public String id;
	public String host;
	
	public Client()
	{
	}
	
	public boolean areCommandLineArgumentsValid(String args[])
	{
		if (args.length != 9) return false;
		if (!args[0].equalsIgnoreCase("-SH")) return false;
		host = args[1];
		
		if (!args[2].equalsIgnoreCase("-N")) return false;
		name = args[3];
		
		if (!args[4].equalsIgnoreCase("-L")) return false;
		x_location = Integer.parseInt(args[5]);
		y_location = Integer.parseInt(args[6]);
		
		if (!args[7].equalsIgnoreCase("-A")) return false;
		age = Integer.parseInt(args[8]);
		
		return true;
	}
	
	public void printErrorMessage()
	{
		System.err.println("Error: This program takes 9 parameters!\n"
				+ "Example usage: -SH hostA -N name -L x y -A age\n"
				+ "hostA should be the host, name is a string, x is an int, y is an int, and age is an int. "
				+ "Also all commandline arguments in the example are needed!\n");
	}
	
	public static void main(String args[])
	{
		Client client = new Client();
		System.setProperty("java.security.policy", "file:./security.policy");
		System.setSecurityManager(new SecurityManager());
		
		//If the commandline arguments are not valid, then error out the program
		if (!client.areCommandLineArgumentsValid(args))
		{
			client.printErrorMessage();
			System.exit(1);
		}
		
		try
		{
			UnicastRemoteObject.exportObject(client, 7777);
			Registry registry = LocateRegistry.getRegistry(client.host);
			
			ServerInterface si = (ServerInterface) registry.lookup(ClientCallbackInterface.NAME);
			client.id = si.register(client);
			System.out.println("Have id: " + client.id);
		}
		catch (Exception e)
		{
			System.out.println("The client failed: " + e);
		}
	}

	@Override
	public void callMe(String message) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
}
