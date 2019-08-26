public class BinarySearch {

    static boolean searchNotRecursive(int [] array, int target){
        // assume array is sorted and not queal null
        int i = 0; int j = array.length -1 ;
        while (i<=j){
            int m = ( i + j ) / 2;
            if (array[m] < target){
                i = m + 1;
            }else if ( target < array[m]){
                j = m -1;
            }else return true;
        }
        return false;
    }

    static boolean searchRecursive(int [] array,int i, int j,  int target) {
        if (i<=j){
            int m = (i+j) / 2;
            if (array[m] < target)
                return searchRecursive(array, m+1, j, target);

            if (target < array[m])
                return searchRecursive(array, i, m-1, target);

            return true;
        }
        return false;
    }


    static boolean search(int [] array, int target){
        return searchRecursive(array, 0, array.length -1, target);
    }

    public static void main(String[] args) {
        System.out.println( search( new int[]{1,2,3,4,5,6}, 3 ) ); // true
        System.out.println( search( new int[]{1,2,3,4,5,6}, 8 ) ); // false
        System.out.println( searchNotRecursive( new int[]{1,2,3,4,5,6}, 1 ) ); // true
        System.out.println( searchNotRecursive( new int[]{1,2,3,4,5,6}, 8 ) ); // false


    }
}
