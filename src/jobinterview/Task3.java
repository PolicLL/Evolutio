package jobinterview;

import java.util.Arrays;

public class Task3
{

    private InsertionSorter sorter;

    public Task3(InsertionSorter sorter)
    {
        this.sorter = sorter;
    }
    
    
    public int calculate(int values[] , int B)
    {
        int []times = new int[values.length];
        sorter.insertionSort(values);
        
        for(int i = 0; i < values.length; ++i)
            if(values[i] != 0)
                times[i] = B / values[i];

        
        if(isThereNegativeNumbers(times) || B < 0)
        {
            System.out.println("Program does not work for negative numbers ! ");
            return -1;
        }
        
        return calculate(values, times, B);
    }

    
   private boolean isThereNegativeNumbers(int array[])
   {
       for(int number : array)
           if(number < 0)
               return true;
       
       return false;
   }
    
    
    private int calculate(int values[] , int times[] , int B)
    {
        int number[] = new int[values.length];
        
        for(int i = 0; i < number.length; ++i)
            number[i] = 0;        
        
        int shortestCombination = Integer.MAX_VALUE;
        int level = 0;
        
        while(!areCombinationsOver(number, times))
        {
            number[level]++;
            
            if(getNumericalValue(number, values) >= B)
            {
                if(getNumericalValue(number, values) == B)
                {
                    printNumber(number , values);
                    shortestCombination = checkForSmallerCombination(number, shortestCombination);
                }

                            
                while(number[level] > times[level])
                {
                
                    if((level + 1) < values.length) // is there another level or we reached maximum level
                    {
                        number[level] = 0; // set current level to 0
                        number[level + 1]++;
                        level++;
                    }
                    
                    if(getNumericalValue(number, values) == B)
                    {
                        printNumber(number , values);
                        shortestCombination = checkForSmallerCombination(number, shortestCombination);
                    }
                }

                level = 0;
            }       
            
        }  
        
        if(shortestCombination == Integer.MAX_VALUE)
            shortestCombination = -1;

        return shortestCombination;
    }

    private boolean areCombinationsOver(int number[], int times[])
    {
        return Arrays.equals(number, times);
    }
    
    private  int checkForSmallerCombination(int number[] , int shortestCombination)
    {
        int usedNumbers = getNumberOfUsedNumbers(number);
                        
        if(shortestCombination > usedNumbers)
            shortestCombination = usedNumbers;
        
        return shortestCombination;
    }
    
    private int getNumericalValue(int array[] , int values[])
    {
        int rez = 0;
        
        for(int i = 0; i < array.length; ++i)
            rez += array[i] * values[i];
        
        return rez;
    }
    
    private int getNumberOfUsedNumbers(int number[])
    {
        int result = 0;
        
        for(int i = 0; i < number.length; ++i)
            result += number[i];
        
        return result;
    }
    
    private void printNumber(int number[] , int values[])
    {
        
        for(int i = 0; i < number.length; ++i)
            for(int j = 0; j < number[i]; ++j)
                System.out.print(values[i] + " ");
        
        System.out.println("");
    }
    
   
    
}
