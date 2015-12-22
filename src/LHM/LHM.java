package LHM;

import java.rmi.*;
import java.util.*;

//Interface No.1 (LHM) extending Remote Class
public interface LHM extends Remote 
    {
        public Vector find(Patient c) throws RemoteException;
    }
