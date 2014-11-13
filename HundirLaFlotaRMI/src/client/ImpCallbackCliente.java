package client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ImpCallbackCliente extends UnicastRemoteObject implements IntCallbackCliente {

	public ImpCallbackCliente() throws RemoteException{
		super();
	}
	
	@Override
	public void notificame(String string) throws RemoteException {
		System.out.println(string);
		
	}

}
