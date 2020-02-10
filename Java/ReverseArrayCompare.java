import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        int i = 0, j= A.length() -1;
        for(int k = 0; k < A.length() /2;k++) {
            // System.out.println("jay darji"+k);
            if(A.charAt(i) == A.charAt(j)) {
                i++;
                j--;
            } else {
                break;
            //System.out.println(A.charAt(i) + " " +  A.charAt(j));
            }
        }
        if(i == A.length() /2) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        
    }
}



