package LHM;

import java.io.*;

public class Patient implements Serializable 
{
    private int age;
    private int sex;
    private String[] hospital;
    private String[] symptom;
    private String Fname;
    private String Sname;
    
    
    //Patient Constructor
    public Patient(int theAge, int theSex, String[] Hospital, String[] Symptom, String fname, String sname) 
    {
        age = theAge;
        sex = theSex;
        hospital = Hospital;
        symptom = Symptom;
        Fname = fname;
        Sname = sname; 
    }
    
    //Getter - Gets the value of getAge() and return it to age;
    public int getAge() 
    {
        return age;
    }
    
    //Getter - Gets the value of getSex() and return it to sex;
    public int getSex() 
    {
        return sex;
    }

    //Boolean Comparison - find out if a patient has been assigned to a doctor or not
    public boolean assignedToHospital(String aHospital) 
            
    {
        if ("".equals(aHospital)) 
            {
                return true;
            }
        
            for (String hospital1 : hospital) 
                {
                    if (hospital1.equals(aHospital)) 
                {
                    return true;
                }
            }

        return false;
    }
    
    //a Method to reset the value of age, sex, hospital, symptom
    public void reset() {
        age = 0;
        sex = 0;
        hospital = null;
        symptom = null;
    }

     //toString() Method for retuning the given values to ResponseBox
    public String toString() 
    {
        String result ="First Name: " + Fname + "\nSurname: " + Sname + "\nAge: " + age + "\nSex: ";
        
        if (sex == History.MALE) 
        
                {
                    result += "Male";
                } 
        
        else if 
                
           (sex == History.FEMALE) 
                {
                    result += "Female";
                } 
        
        else 
           
                {
                    result += "Male or Female";
                }
        
        result += "\nHospital(s): ";
        
        for (String hospital1 : hospital) 
                {
                    result += hospital1;
                }
        
        result += "\nSymptom(s): ";
        

            for (String symptom : symptom) 
                {
                    result += symptom;
                }

        return result;
    }
}
