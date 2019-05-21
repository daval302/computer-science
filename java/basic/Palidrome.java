package basic;

import java.util.Arrays;
import java.util.Iterator;

public class Palidrome {

    /*
    * Two methods to check if string is palindrome:
    * 1) do reverse string and check is equal
    * 2) start from edge and go middle, chek if character are equal
    * */

    static boolean isPalindrome(char [] str){
        // do reverse anc check equals
        if (str == null || str.length == 0){
            return false;
        }
        int left  = 0;
        int right  = str.length - 1;
        while(left < right){
            if (str[left] != str[right])
                return false;
            left++;
            right--;
        }
        return true;
    }

    static boolean isPalindrome(String  str) {
        if (str == null || str.length() == 0){
            return false;
        }
        int left  = 0;
        int right  = str.length() - 1;
        while(left < right){
            if (str.charAt(left) != str.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }


    public static String findLongestPalindrome(String s) {
        if (s==null || s.length()==0)
            return "";

        String longest  = s.substring(0,1);
        for(int i = 0; i< s.length() -1 ; i++){
            String tmp;
            // case pair
            if (s.charAt(i) == s.charAt(i+1)){
                int left = i-1; int right = i + 2;
                while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                    left--; right++;
                }
                tmp = s.substring(left+1, right);
            }else {
                int left = i-1; int right = i + 1;
                while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                    left--; right++;
                }
                tmp = s.substring(left+1, right);
            }
            if (tmp.length() > longest.length()){
                longest = tmp;
            }

        }

        return longest;
    }

    static boolean isPalindrome(int n){
        int i,sum =0, t = n;
        while(n>0){
            i = n % 10 ;
            sum = (sum * 10) + i;
            n = n / 10;
        }

        if (t == sum)
            return true;

        return false;

    }


    public static void main(String[] args) {
        System.out.println(isPalindrome( 454 ));
    }
}
