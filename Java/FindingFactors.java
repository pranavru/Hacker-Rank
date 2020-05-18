import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
    // Write your code here
        
        int lcm = gcd_lcm(a, false);
        int gcd = gcd_lcm(b, true);
        int count = 0;
        System.out.println(a);
        System.out.println(b);
        System.out.println("LCM: " + lcm + " GCD: " + gcd);
        for(int i = lcm, j = 2; i <= gcd; i = lcm *j, j++) {
            System.out.println(i + " " + j + " " + gcd %i);
            if(gcd %i == 0)
                count++;
        }
        return count;
    }

    public static int getGCD(int x, int y) {
        while(y > 0) {
            int temp = y;
            y = x%y;
            x = temp;
        }
        return x;
    }

    public static int getLCM( int a, int b) {
        return a * (b / getGCD(a, b));
    }

    public static int gcd_lcm(List<Integer> a, boolean TF) {
        int value = a.get(0);
        for(int item: a) {
            value = TF ? getGCD(value, item): getLCM(value, item);
        }
        return value;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
