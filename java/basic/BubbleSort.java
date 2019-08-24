import java.util.Arrays;

public class BubbleSort {  
    static void sort(int[] arr) {  
        int n = arr.length;  
        int temp;
        int swapped;
        do {
            swapped = 0;
            for(int i=0; i < n -1; i++){
                if(arr[i] > arr[i+1]){  
                    //swap elements  
                    temp = arr[i];  
                    arr[i] = arr[i+1];  
                    arr[i+1] = temp;  
                    swapped++;
                }  
            }
        } while (swapped > 0);
  
    }  
    public static void main(String[] args) {  
                
        int arr[] ={3,2,5,1,7,4};

        sort(arr);

        System.out.println( Arrays.toString(arr)); // [1, 2, 3, 4, 5, 7]
                 
    }  
}  