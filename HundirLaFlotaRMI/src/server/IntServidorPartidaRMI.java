package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import common.Partida;

public interface IntServidorPartidaRMI extends Remote {
	public Partida nuevaPartida(int numFilas, int numCols, int numBarcos) throws RemoteException;
	public int pruebaCasilla(int numFil, int numCol) throws RemoteException;
	public String getBarco(int id) throws RemoteException;
	public String[] getSolucion() throws RemoteException;
	public int getDisparos() throws RemoteException;
	public int getQuedan() throws RemoteException;
	
}
