

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class Client extends UnicastRemoteObject implements ClientInterface, Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public serverInterface server;
	public String name;
	
	protected Client(String name, serverInterface server) throws RemoteException {
		this.name = name;
		this.server = server;
		server.register(this);
	}

	@Override
	public void retrieve(String message) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String message;
		
		while(true)
		{
			message = sc.nextLine();
			try{
				server.message(name + " : " + message);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

}
