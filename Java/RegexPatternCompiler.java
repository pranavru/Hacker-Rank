import java.util.Scanner;
import java.util.regex.*;

public class Solution
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while(testCases>0){
			String pattern = in.nextLine();
          	//Write your code
            boolean isRegex;
            try {
                Pattern.compile(pattern);
                isRegex = true;
            } catch (PatternSyntaxException e) {
                isRegex = false;
            }
            if(isRegex) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }
            testCases-- ;
		}
	}
}
