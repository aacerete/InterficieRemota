import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Dionis on 22/02/2016.
 */
public interface RMIServerInterficie extends Remote{

    String suma(String mensaje) throws RemoteException;
    String resta(String mensaje) throws RemoteException;
    String divisio(String mensaje) throws RemoteException;
    String multiplicacio(String mensaje) throws RemoteException;
}
