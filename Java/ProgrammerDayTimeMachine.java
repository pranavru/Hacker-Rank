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

public class Solution {

    // Complete the dayOfProgrammer function below.
    static String dayOfProgrammer(int year) {

        int caseYear = -1, noOfDays = -1; boolean isLeapYear = false;
        int noOfAllDays = 215;
        if(2700 >= year && year > 1918) {
            if(year %400 == 0 || (year %4 == 0 && year %100 != 0))
                    isLeapYear = true;
            
            noOfDays = noOfAllDays + (isLeapYear ? 29 : 28);
            System.out.println(noOfDays + " " + noOfAllDays + " " + isLeapYear);
        } else if(1700 <= year && year < 1918) {
            if(year %4 == 0)
                    isLeapYear = true;
            //32nd Day is Feb 14 of that year
            noOfDays = noOfAllDays + (isLeapYear ? 29 : 28);
            System.out.println(noOfDays + " " + noOfAllDays + " " + isLeapYear);
        } else {
            noOfDays = noOfAllDays +15;
        }
        
        return ((256 - noOfDays) + ".09." + year);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
