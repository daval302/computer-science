import java.util.Arrays;

class QuickSort{

    public static int partition(int[] array, int lo, int hi){
        int pivot  = array[hi];
        int i = lo - 1;
        for (int j = lo; j< hi; j++){
            if (array[j] <= pivot){
                i++;
               // swap arr[i] and arr[j] 
               int temp = array[i]; 
               array[i] = array[j]; 
               array[j] = temp; 
            }
        }

       // swap arr[i+1] and arr[high] (or pivot) 
        int temp = array[i+1]; 
        array[i+1] = array[hi]; 
        array[hi] = temp; 

        return i+1;
    }

    public static int[] sort(int[] array, int lo, int hi){
        if (lo < hi){
            int p = partition(array, lo, hi);
            sort(array, lo, p - 1);
            sort(array, p + 1, hi);
        }
        return array;
    }

    public static void main(String ... args){

        int arr [] = new int[]{2,3,1,5};

        System.out.println(  Arrays.toString( 
            sort( arr, 0, arr.length - 1) 
        ));
    }
}