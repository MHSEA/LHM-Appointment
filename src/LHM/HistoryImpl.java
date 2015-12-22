package LHM;

import java.rmi.*;
import java.rmi.server.*;
import java.text.*;
import java.util.*;


public class HistoryImpl extends UnicastRemoteObject implements History 
    {
        public String name;
        private int ageLow;
        private int ageHigh;
        private int sex;
        private String hospital;
        
    //Constructor     
    public HistoryImpl(String n, int s, int age1, int age2, String h) 
        throws RemoteException 
        {
            name = n;
            ageLow = age1;
            ageHigh = age2;
            sex = s;
            hospital = h;
        }
    
    // local method
    public boolean match(Patient c) 
        {
            if (c.getAge() < ageLow || c.getAge() > ageHigh) 
                {
                return false;
                }
            
            if (!c.assignedToHospital(hospital)) 
                {
                    return false;
                }
            if ((sex & c.getSex()) == 0) 
                {
                return false;
                }
        return true;
        }
    
    //Setting Time and Date Format
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
    Date date = new Date();
    
    //Returns Doctor's name, Date and time on GUI ResponseBox
    public String getDescription() throws RemoteException 
    
        {
            return "\nDear Patient you have been assigned to doctor: " + name + 
                   "\nAnd you details has been passed to our teem on: " + dateFormat.format(date)+"" ;
        }
}