package quicksort;

public class Main {
    private static int partition(int sortArray[],int low,int hight)
    {
        int key = sortArray[low];
         
        while(low<hight)
        {
            while(low<hight && sortArray[hight]>=key)
                hight--;
            sortArray[low] = sortArray[hight];
             
            while(low<hight && sortArray[low]<=key)
                low++;
            sortArray[hight] = sortArray[low];
        }
        sortArray[low] = key;
        return low;
    }
     
    public static void sort(int data[],int low,int hight)
    {
        if(low<hight)
        {
            int result = partition(data,low,hight);
            sort(data,low,result-1);
            sort(data,result+1,hight);
        }
         
    }
}
