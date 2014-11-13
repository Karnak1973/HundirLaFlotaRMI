package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import client.IntCallbackCliente;


public class ImplServidorJuegoRMI extends UnicastRemoteObject implements IntServidorJuegoRMI {
	
	private Map<String, IntCallbackCliente> mapPartidas = null;
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de la clase
	 * @throws	RemoteException
	 */
	public ImplServidorJuegoRMI() throws RemoteException {
		super();
		this.mapPartidas = new ConcurrentHashMap<String, IntCallbackCliente>();
		System.out.println("Instancio un ImplServidorJuegoRMI");
	}
	
	/**
	 * Instancia y devuelve un objeto remoto servidor de partida
	 */
   public IntServidorPartidaRMI nuevoGestorPartida() throws RemoteException {
	   return (IntServidorPartidaRMI) new ImplServidorPartidaRMI();
   }
   
   /**
	 * Permite al cliente proponer una partida y registrarse para callback cuando se alguien la acepte
	 * @param	nombreJugador			nombre del jugador que propone la partida
	 * @param	objCallbackCliente	referencia al objeto del jugador que usara el servidor para hacer el callback
	 * @return							valor logico indicando si se ha podido anyadir el jugador del registro
	 * @throws	RemoteException
	 */
  public synchronized boolean proponPartida( String nombreJugador, IntCallbackCliente objCallbackCliente) throws RemoteException {
	    
	  if ( !mapPartidas.containsKey(nombreJugador) ) {
	    	mapPartidas.put(nombreJugador, objCallbackCliente);
	        System.out.println(nombreJugador + " ha propuesto una nueva partida.");
	        return true;
	    } 
	    else {
	    	System.out.println("ERROR: " + nombreJugador + " ya había propuesto una partida.");
	    	return false;
	    }
  }
  
  
  /**
	 * Permite a un cliente eliminar su registro para callback
	 * @param	nombreJugador			nombre del jugador que propone la partida
	 * @return							valor logico indicando si se ha podido eliminar el jugador del registro
	 * @throws	RemoteException
	 */
  public synchronized boolean borraPartida( String nombreJugador) throws RemoteException {
	    if (mapPartidas.containsKey(nombreJugador)) {
	    	mapPartidas.remove(nombreJugador);
	      System.out.println("Borrada partida propuesta por " + nombreJugador);
	      return true;
	    } else {
	       System.out.println("ERROR: " + nombreJugador + " no ha propuesto ninguna partida.");
	       return false;
	    }
  }
  
  /**
	 * Lista las partidas propuestas
	 * @return							vector de cadenas asociadas a cada partida propuesta
	 * @throws	RemoteException
	 */
  public String[] listaPartidas() throws RemoteException {
	  Set<String> conjuntoNombres = mapPartidas.keySet();
	  return conjuntoNombres.toArray(new String[0]);
  }
  
  /**
	 * Acepta jugar una de las partidas propuestas
	 * @param	idPartida	nombre del jugador que propuso la partida
	 * @return				valor logico indicando si se ha podido aceptar la partida
	 * @throws	RemoteException
	 */
  public synchronized boolean aceptaPartida(String nombreJugador, String nombreRival) throws RemoteException {
	    if (mapPartidas.containsKey(nombreRival)) {
	    	IntCallbackCliente objCallback = (IntCallbackCliente) mapPartidas.get(nombreRival);
			// borramos al rival de la lista de callbacks
			mapPartidas.remove(nombreRival);
			// notificamos al rival quién ha aceptado su partida
	 	    try {
	 	         objCallback.notificame(nombreJugador + " ha aceptado tu partida.");
	 	         System.out.println(nombreJugador + " ha aceptado la partida propuesta por " + nombreRival);
	 	         return true;
	 		}
	 		 catch (RemoteException e) {
	 			 System.out.println("Excepcion cuando el servidor ha intentado notificar a " + nombreRival);
	 			 return false;
	 		 }

	    } else {
	       System.out.println("ERROR: " + nombreRival + " no ha propuesto ninguna partida.");
	       return false;
	    }
  }
  
} // end class ImplServidorFlotaRMI
