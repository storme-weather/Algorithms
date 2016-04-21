import java.rmi.*;

public interface ClientCallbackInterface extends Remote{
	public static final String NAME = "CallbackClient";
	
	public void callMe(String message) throws RemoteException;
}
