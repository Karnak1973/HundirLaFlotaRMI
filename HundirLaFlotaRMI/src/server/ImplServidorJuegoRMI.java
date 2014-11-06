package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ImplServidorJuegoRMI extends UnicastRemoteObject implements IntServidorJuegoRMI {

	public ImplServidorJuegoRMI() throws RemoteException {
		super();
	}

	@Override
	public IntServidorPartidaRMI nuevoGestorPartida() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
