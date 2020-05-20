import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the pageCount function below.
     */
    static int pageCount(int n, int p) {
        /*
         * Write your code here.
         */
        int frontTurn = -1, backTurn = -1;
        int middleValue = (n +1)/2;
        if(n == p) return 0;
        if(n -p == 1 && p > middleValue && n%2 == 0) return 1;
        if(p >= middleValue) {
            for(int i = n -1; i > 0; i -=2) {
                backTurn++;
                if(i == p || i +1 == p) 
                    break;
                System.out.println("p " + p + " i " + i + " backTurn " + backTurn);
                if(i == p || i +1 == p) 
                    break;
            }
        } 
        if(p <= middleValue) {
            for(int i = 1; i < n -1; i +=2) {
                frontTurn++;
                System.out.println("p " + p + " i " + i + " frontTurn " + frontTurn);
                if(i == p || i -1 == p) 
                    break;
            }
        }
        if(backTurn != -1 && frontTurn != -1) {
            return backTurn > frontTurn ? frontTurn : backTurn;
        }
        return backTurn == -1 ? frontTurn : backTurn;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int result = pageCount(n, p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
