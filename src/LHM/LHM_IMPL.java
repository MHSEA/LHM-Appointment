package LHM;

import java.rmi.*;
import java.util.*;
import java.rmi.server.*;

public class LHM_IMPL extends UnicastRemoteObject implements LHM 
    {
        private Vector products;

        public LHM_IMPL() throws RemoteException 
            {
                products = new Vector();
            }
        // local method
        public synchronized void add(HistoryImpl p) 
            {
                products.add(p);
            }
        
        public synchronized Vector find(Patient c) throws RemoteException 
            {
                Vector result = new Vector();
                for (int i = 0; i < products.size(); i++) 
                    {
                        HistoryImpl p = (HistoryImpl) products.get(i);
                        if (p.match(c)) 
                    {
                        result.add(p);
                    }
            }
        // Printing Static Information at the end of result
        //result.add(new HistoryImpl("name", 0, 200, History.BOTH, ""));
        c.reset();
        return result;
    } 
}
