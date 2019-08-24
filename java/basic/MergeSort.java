import java.util.Arrays;

class MergeSort{

    public static void merge(int arr[], int l, int m, int r){
        
        // sizes
        int n1 = m - l + 1;
        int n2 = r - m;

        // temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // copy data to temp arrays
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 
        
        // merge temp arrays
        int i = 0; int j = 0; int k = l;

        while (i < n1 && j < n2){
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        }

            /* Copy remaining elements of L[] if any */
            while (i < n1) { 
                arr[k] = L[i]; 
                i++; 
                k++; 
            } 
    
            /* Copy remaining elements of R[] if any */
            while (j < n2) { 
                arr[k] = R[j]; 
                j++; 
                k++; 
            } 
        
    }

    public static void sort(int arr[], int l, int r){
        if (l < r){
            int m = (l+r) / 2;
            sort(arr, l, m);
            sort(arr, m+1, r);
            merge(arr, l, m ,r);
        }

    }

    public static void main(String ... args){
        
        int [] A = new int[]{2,5,4,3,7};

        sort(A, 0, A.length - 1);

        // 2 3 4 5 7 
        System.out.println(
            Arrays.toString(A)
        );
    }
}