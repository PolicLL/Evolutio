package jobinterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JobInterview 
{
    public static void main(String[] args)
    {
        
        
        
        Task3 task3 = new Task3(new InsertionSorter());
        
        int[] values = {5 , 7 , -1};
        int B = 11;
        
        System.out.println("");
        System.err.println("SHORTEST COMBINATION : " + task3.calculate(values, B));

        
    }
    
    
    
    
          

}
