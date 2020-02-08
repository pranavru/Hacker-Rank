import java.util.Scanner;
import java.lang.String;

public class Solution {

    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.println("================================");
            for(int i=0;i<3;i++)
            {
                String s1=sc.next();
                int x=sc.nextInt();
                String padded = String.format("%-" + (14) + "s", s1);
                //Complete this line
                if(Integer.toString(x).length() >= 3) {
                    System.out.println(padded + " " + x);
                } else {
                    String formatted = String.format("%03d", x);
                    System.out.println(padded + " " + formatted);
                }
                
            }
            System.out.println("================================");

    }
}



