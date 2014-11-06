package server;

import java.rmi.RemoteException;

import common.Partida;

public class ImplServidorPartidaRMI implements IntServidorPartidaRMI {

	@Override
	public Partida nuevaPartida(int numFilas, int numCols, int numBarcos)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int pruebaCasilla(int numFil, int numCol) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getBarco(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getSolucion() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
