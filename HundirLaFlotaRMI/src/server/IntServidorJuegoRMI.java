package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import client.IntCallbackCliente;

public interface IntServidorJuegoRMI extends Remote {
	public IntServidorPartidaRMI nuevoGestorPartida() throws RemoteException;
	public boolean proponPartida( String nombreJugador, IntCallbackCliente objCallbackCliente) throws RemoteException;
	public boolean borraPartida( String nombreJugador) throws RemoteException;
	public String[] listaPartidas() throws RemoteException;
	public boolean aceptaPartida(String nombreJugador, String nombreRival) throws RemoteException;
	
}
