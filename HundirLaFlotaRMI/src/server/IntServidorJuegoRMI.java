package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IntServidorJuegoRMI extends Remote {
	public IntServidorPartidaRMI nuevoGestorPartida() throws RemoteException;
}
