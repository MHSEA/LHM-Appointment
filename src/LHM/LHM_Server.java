package LHM;

import java.rmi.*;

public class LHM_Server
{   
    public static void main(String[] args) 
    {
        try 
            {
                System.out.println("Constructing server implementations...");
                
                LHM_IMPL w = new LHM_IMPL();
                assignDr(w);

                System.out.println("Binding server implementations to registry...");
                Naming.rebind("LHM-Appointment", w);
                System.out.println("Waiting for invocations from clients...");
            } 
        
        catch (Exception e) 
            {
                System.out.println("Error: " + e);
            }
    }
    
    // This method will assign a doctor to patient based on the given information
    public static void assignDr(LHM_IMPL w) throws RemoteException 
    {
        w.add(new HistoryImpl("Dr.Priscilla Riggs", History.BOTH, 18, 100, "Croydon"));
        w.add(new HistoryImpl("Dr.Dakota Vazquez", History.BOTH, 18, 100, "Chiltern"));
        w.add(new HistoryImpl("Dr.Rogan Schroeder", History.BOTH, 18, 100, "Herefordshire"));
        w.add(new HistoryImpl("Dr.Jemima Dale", History.BOTH, 20, 100, "Hillingdon"));
        w.add(new HistoryImpl("Dr.Elizabeth Freeman", History.BOTH, 20, 100, "Shropshire"));
        w.add(new HistoryImpl("Dr.Alvin Pittman", History.BOTH, 20, 100, "Luton"));
        w.add(new HistoryImpl("Dr.Brenden Vaughn", History.BOTH, 15, 100, "Sutton"));
        w.add(new HistoryImpl("Dr.Wesley Martinez", History.BOTH, 6, 100, "Reading"));
        w.add(new HistoryImpl("Dr.Rhonda Vaughan", History.BOTH, 6, 100, "Wiltshire"));
        w.add(new HistoryImpl("Dr.Zelenia Oneill", History.BOTH, 20, 100, "Norfolk"));
        w.add(new HistoryImpl("Dr.Amela Wolfe", History.BOTH, 6, 100, "ValeRoyal"));
        w.add(new HistoryImpl("Dr.Erasmus Bowman", History.BOTH, 20, 100, "London"));
        w.add(new HistoryImpl("Dr.Illiana Norton", History.BOTH, 20, 100, "Bristol"));
    }   
}