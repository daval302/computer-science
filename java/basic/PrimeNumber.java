package basic;

public class PrimeNumber {
    static boolean isPrime(int num){
        // assert that num is greater then or equal 0
        if (num == 0 || num == 1)
            return false;
        int m = num / 2;
        for (int i = 2; i <=m; i++){
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println( isPrime( 6 ) );
    }
}
