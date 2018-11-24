package cz.speedygonzales.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by: vondracek - 6.3.15 10:17
 */
public interface MyRemoteInterface extends Remote {

    int add(int x, int y) throws RemoteException;

}
