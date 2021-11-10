package jobinterview;

public class InsertionSorter 
{

    public InsertionSorter()
    {
        
    }
    
    public  void insertionSort(int array[])
    {
        for(int i = 1; i < array.length; ++i)
        {
            int element = array[i];
            int j = i - 1;
            
            while((j > -1) && (element < array[j]))
            {
                array[j + 1] = array[j];
                --j;
            }
            
            array[j + 1] = element;
        }
    }
    
    
}
