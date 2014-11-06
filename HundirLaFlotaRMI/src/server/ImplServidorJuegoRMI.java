package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ImplServidorJuegoRMI extends UnicastRemoteObject implements IntServidorJuegoRMI {


	
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de la clase
	 * @throws	RemoteException
	 */
	public ImplServidorJuegoRMI() throws RemoteException {
		super(); 
		System.out.println("Instancio un ImplServidorJuegoRMI");
	}
	
	/**
	 * Instancia y devuelve un objeto remoto servidor de partida
	 */
   public IntServidorPartidaRMI nuevoGestorPartida() throws RemoteException {
	   return (IntServidorPartidaRMI) new ImplServidorPartidaRMI();
   }
   
   
}
