package server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServidorFlotaRMI {

	/* 
	 * Esta clase implementa el servidor de objeto de un objeto distribuido
	 * de la clase ImplServidorJuegoRMI que implementa la interfaz remota
	 * IntServidorJuegoRMI.
	 * 
	 * El código principal crea una instancia del objeto, arranca el registro RMI en numPuertoRMI,
	 * y registra el objeto.
	 */
	
	public static void main(String[] args) {
		String URLRegistro;
		String numPuertoRMI = "1099";
		try {
			ImplServidorJuegoRMI juegoExportado = new ImplServidorJuegoRMI();
			arrancaRegistro(Integer.parseInt(numPuertoRMI));
			URLRegistro = "rmi://localhost:" + numPuertoRMI + "/hundirLaFlota";
			Naming.rebind(URLRegistro, juegoExportado);
			System.out.println("El servidor del juego está listo.");
		} catch (Exception e){
			System.out.println("Excepción en ServidorFlotaRMI.main: " + e);
		}
	}
	
	
	/*
	 * Este método arranca el registro RMI en el puérto especificado, si no existe 
	 * crea un nuevo registro.
	 */
	
	private static void arrancaRegistro(int numPuerto) throws RemoteException{
		try {
			Registry registro = LocateRegistry.getRegistry(numPuerto);
			registro.list();
		} catch (RemoteException e) {
			System.out.println("El registro RMI no se ha podido localizar en el puerto: " + numPuerto);
			Registry registro = LocateRegistry.createRegistry(numPuerto);
			System.out.println("Registro RMI creado en el puerto: " +numPuerto);
		}
	}
}
