package cz.speedygonzales.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by: vondracek - 6.3.15 10:19
 */
public class MyRemoteInterfaceImpl extends UnicastRemoteObject implements MyRemoteInterface {

    protected MyRemoteInterfaceImpl() throws RemoteException {

        super();
    }

    @Override
    public int add(int x, int y) throws RemoteException {

        return x + y;
    }
}
