package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import common.Partida;

public class ImplServidorPartidaRMI extends UnicastRemoteObject implements IntServidorPartidaRMI {
	private Partida partida;
	
	protected ImplServidorPartidaRMI() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Partida nuevaPartida(int numFilas, int numCols, int numBarcos)
			throws RemoteException {
		
		Partida partida = new Partida(numFilas, numCols, numBarcos);
		
		return partida;
	}

	@Override
	public int pruebaCasilla(int numFil, int numCol) throws RemoteException {
		return this.partida.pruebaCasilla(numFil, numCol);
	}

	@Override
	public String getBarco(int id) throws RemoteException {
		return this.partida.getBarco(id);
	}

	@Override
	public String[] getSolucion() throws RemoteException {
		return this.partida.getSolucion();
	}

}
