package LHM;

import java.rmi.*;

//Interface No.2 (History) extending Remote Class
public interface History extends Remote 
    {
        String getDescription() throws RemoteException;
        
        static final int MALE = 1;      //Assign 1 to Male  (BOOLEAN)
        static final int FEMALE = 2;    //Assign 2 to Female(BOOLEAN)
        static final int BOTH = MALE + FEMALE;  //Assign Male + Female to both(BOOLEAN)
    
    }

