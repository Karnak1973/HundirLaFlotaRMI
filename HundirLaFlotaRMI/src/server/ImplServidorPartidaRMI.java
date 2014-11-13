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
	public void nuevaPartida(int numFilas, int numCols, int numBarcos)
			throws RemoteException {
		
		this.partida = new Partida(numFilas, numCols, numBarcos);
		
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

	@Override
	public int getDisparos() throws RemoteException {
		return partida.getDisparos();
	}

	@Override
	public int getQuedan() throws RemoteException {
		return partida.getQuedan();
	}

}
